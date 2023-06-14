package uz.najottalim.bankingapp.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.dto.AccountDto;
import uz.najottalim.bankingapp.dto.RoleDto;
import uz.najottalim.bankingapp.exception.NoResourceNotFoundException;
import uz.najottalim.bankingapp.model.Account;
import uz.najottalim.bankingapp.mapper.AccountMapping;
import uz.najottalim.bankingapp.model.Role;
import uz.najottalim.bankingapp.repository.AccountRepository;
import uz.najottalim.bankingapp.repository.AuthorityRepository;
import uz.najottalim.bankingapp.repository.RoleRepository;
import uz.najottalim.bankingapp.service.AccountService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService, UserDetailsService {
    private final AccountRepository accountRepository;
    private final AccountMapping accountMapping = new AccountMapping();
    private final RoleRepository roleRepository;
    private final AuthorityRepository authorityRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = accountRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        Role role = roleRepository.findById(account.getRole().getId()).orElseThrow(() -> new IllegalArgumentException("Role not found"));

        List<Role> childRolesAndOwnRole = new ArrayList<>(roleRepository.findRoleByParentRole(role));
        childRolesAndOwnRole.add(role);

        List<SimpleGrantedAuthority> allAuthorities = new ArrayList<>(childRolesAndOwnRole.stream()
                .flatMap(rr -> authorityRepository.findByRole(rr).stream())
                .distinct()
                .map(aa -> new SimpleGrantedAuthority(aa.getName()))
                .toList());

        allAuthorities.addAll(childRolesAndOwnRole.stream()
                .map(aa -> new SimpleGrantedAuthority(aa.getName()))
                .toList()
        );

        return new User(account.getName(), account.getPassword(), allAuthorities);
    }

    @Override
    public ResponseEntity<AccountDto> findById(Long id) {
        Optional<Account> byId = accountRepository.findById(id);
        if (byId.isEmpty()){
            throw new NoResourceNotFoundException("Email must not be empty");
        }
        return ResponseEntity.ok(accountMapping.toDto(byId.get()));
    }

    @Override
    public ResponseEntity<List<AccountDto>> findAll() {
        List<Account> all = accountRepository.findAll();
        return ResponseEntity.ok(all.stream().map(accountMapping::toDto).toList());
    }

    @Override
    public ResponseEntity<AccountDto> save(AccountDto accountDTO) {
        accountDTO.setRoleDto(new RoleDto(1L, "ROLE_USER"));
        Account account = accountMapping.toEntity(accountDTO);
        Account account1 = accountRepository.save(account);

        return ResponseEntity.ok(accountMapping.toDto(account1));
    }

    @Override
    public void delete(Long id) {
        Optional<Account> byId = accountRepository.findById(id);
        if (byId.isEmpty()) {
            throw new NoResourceNotFoundException("Email must not be empty");
        } else {
            System.out.println(accountMapping.toDto(byId.get()));
            accountRepository.delete(byId.get());
        }
    }

    @Override
    public ResponseEntity<AccountDto> update(AccountDto accountDto) {
        Optional<Account> byId = accountRepository.findById(accountDto.getId());
        if (byId.isEmpty()){
            throw new NoResourceNotFoundException("Email must not be empty");
        }
        return null;
    }
}
