package uz.najottalim.bankingapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.dto.AccountDTO;
import uz.najottalim.bankingapp.dto.RoleDTO;
import uz.najottalim.bankingapp.mapper.AccountMapper;
import uz.najottalim.bankingapp.model.Account;
import uz.najottalim.bankingapp.model.Authority;
import uz.najottalim.bankingapp.model.Role;
import uz.najottalim.bankingapp.repository.AccountRepository;
import uz.najottalim.bankingapp.repository.AuthorityRepository;
import uz.najottalim.bankingapp.repository.RoleRepository;
import uz.najottalim.bankingapp.service.AccountService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService, UserDetailsService {
    final private AccountRepository accountRepository;
    final private RoleRepository roleRepository;
    final private AuthorityRepository authorityRepository;


    @Override
    public ResponseEntity<List<AccountDTO>> getAllAccounts() {
        List<Account> all = accountRepository.findAll();
        return ResponseEntity.ok(all.stream().map(AccountMapper::toDto).collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<AccountDTO> addAccount(AccountDTO accountDTO) {
        accountDTO.setRoleDTO(new RoleDTO(1L, "ROLE_USER"));
        Account account = AccountMapper.toEntity(accountDTO);
        Account account1 = accountRepository.save(account);

        return ResponseEntity.ok(AccountMapper.toDto(account1));
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
