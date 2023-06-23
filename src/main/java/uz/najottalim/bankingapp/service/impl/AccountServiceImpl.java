package uz.najottalim.bankingapp.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.dto.AccountDto;
import uz.najottalim.bankingapp.exceptions.NotFoundException;
import uz.najottalim.bankingapp.mapper.AccountMapper;
import uz.najottalim.bankingapp.models.Account;
import uz.najottalim.bankingapp.models.Authority;
import uz.najottalim.bankingapp.models.Role;
import uz.najottalim.bankingapp.repository.AccountRepository;
import uz.najottalim.bankingapp.repository.AuthorityRepository;
import uz.najottalim.bankingapp.repository.RoleRepository;
import uz.najottalim.bankingapp.service.AccountService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService, UserDetailsService {
    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;
    private final AuthorityRepository authorityRepository;
    private final AccountMapper accountMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = (Account) accountRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("cannot load user: "+username));

        Role role = roleRepository.findById(account.getRole().getId())
                .orElseThrow(() -> new IllegalArgumentException("Role not found"));

        List<Role> childRolesAndOwnRole = new ArrayList<>();
        childRolesAndOwnRole.add(role);

        List<Role> parentRole = new ArrayList<>();
        parentRole.add(role);

        while (true) {
            List<Role> roles = getRoles(parentRole);
            if (roles.isEmpty()) {
                break;
            }
            childRolesAndOwnRole.addAll(roles);
            parentRole = roles;
        }

        List<SimpleGrantedAuthority> allAuthorities = childRolesAndOwnRole
                .stream()
                .flatMap(roleItem -> Stream.concat(
                        Stream.of(roleItem.getName()),
                        authorityRepository.findByRole(roleItem)
                                .stream()
                                .map(Authority::getName)))
                .map(SimpleGrantedAuthority::new)
                .toList();

        return new User(account.getEmail(), account.getPassword(), allAuthorities);
    }

    private List<Role> getRoles(List<Role> parentRole) {
        List<Role> allRoles = new ArrayList<>();
        for (Role role : parentRole) {
            allRoles.addAll(roleRepository.findRoleByParentRole(role));
        }

        return allRoles;
    }

    @Override
    public ResponseEntity<AccountDto> getAccountById(Long id) {
        Account user = accountRepository.findById(id).orElseThrow(
                () -> new NotFoundException("User not found")
        );

        return ResponseEntity.ok(accountMapper.toDto(user));
    }

    @Override
    public ResponseEntity<List<AccountDto>> getAllAccounts(Optional<String> sortBy, Optional<Integer> size, Optional<Integer> pageNum) {
        String sortByColumnName = "id";
        if (sortBy.isPresent()){
            List<String> columnNames = List.of("name","email","mobileNumber","accountNumber","address","password","accountType","role");
            String s = sortBy.get();
            if (columnNames.contains(s)){
                sortByColumnName = s;
            }
        }

        Sort sort = Sort.by(sortByColumnName);
        PageRequest pageRequest = null;

        if (size.isPresent() && pageNum.isPresent()){
            pageRequest = PageRequest.of(pageNum.get(), size.get(), sort);
        }

        List<Account> accounts;
        if (pageRequest != null){
            accounts = accountRepository.findAll(pageRequest).stream().toList();
        } else {
            accounts = accountRepository.findAll(sort);
        }

        return ResponseEntity.ok(accounts.stream().map(accountMapper::toDto).toList());
    }
}
