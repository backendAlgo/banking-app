package uz.najottalim.bankingapp.Service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.Entity.Account;
import uz.najottalim.bankingapp.Entity.Role;
import uz.najottalim.bankingapp.Service.AccountService;
import uz.najottalim.bankingapp.repository.AccountRepository;
import uz.najottalim.bankingapp.dto.AccountDto;
import uz.najottalim.bankingapp.mapper.AccountMapper;
import uz.najottalim.bankingapp.repository.AuthorityRepository;
import uz.najottalim.bankingapp.repository.RoleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService, UserDetailsService {

    private final AccountRepository accountRepository;
    final private RoleRepository roleRepository;
    private final AuthorityRepository authorityRepository;


    @Override
    public ResponseEntity<List<AccountDto>> getAll() {
        List<AccountDto> accountDtos = accountRepository.findAll().stream().map(account -> AccountMapper.toDto(account)).collect(Collectors.toList());
        return ResponseEntity.ok(accountDtos);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {


        Account account = accountRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("cannot load user: "));

        Role role = roleRepository.findById(account.getRole().getId())
                .orElseThrow(() -> new IllegalArgumentException("Role not found"));

        List<Role> childRolesAndOwnRole = new ArrayList<>(roleRepository.findRoleByParentRole(role));
        childRolesAndOwnRole.add(role);

        List<SimpleGrantedAuthority> allAuthorities = new ArrayList<>(childRolesAndOwnRole.stream()
                .flatMap(rr -> authorityRepository.findByRoles(rr).stream())
                .distinct()
                .map(aa -> new SimpleGrantedAuthority(aa.getName()))
                .toList());

        allAuthorities.addAll(childRolesAndOwnRole.stream()
                .map(aa -> new SimpleGrantedAuthority(aa.getName()))
                .toList()
        );
        return new User(account.getEmail(), account.getPassword(), allAuthorities);
    }
}
