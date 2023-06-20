package uz.najottalim.bankingapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.Repository.AccountRepository;
import uz.najottalim.bankingapp.Repository.AuthorityRepository;
import uz.najottalim.bankingapp.Repository.RoleRepository;
import uz.najottalim.bankingapp.entity.Account;
import uz.najottalim.bankingapp.entity.Authority;
import uz.najottalim.bankingapp.entity.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class CostumerUserDetailsService implements UserDetailsService {
    private  final AccountRepository accountRepository;
    private final RoleRepository roleRepository;
    private final AuthorityRepository authorityRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = (Account) accountRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("cannot load user: "));

        Role role = roleRepository.findById(account.getRoles().getId())
                .orElseThrow(() -> new IllegalArgumentException("Role not found"));

        List<Role> childRolesAndOwnRole = new ArrayList<>(roleRepository.findRoleByParentRole(role));
        childRolesAndOwnRole.add(role);

        List<SimpleGrantedAuthority> allAuthorities = childRolesAndOwnRole
                .stream()
                .flatMap(roleItem -> Stream.concat(
                        Stream.of(roleItem.getName()),
                        authorityRepository.findByRoles(roleItem)
                                .stream()
                                .map(Authority::getName)))
                .map(SimpleGrantedAuthority::new)
                .toList();

        return new User(account.getEmail(), account.getPassword(), allAuthorities);
    }
}
