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
import uz.najottalim.bankingapp.entity.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CostumerUserDetailsService implements UserDetailsService {
    private  final AccountRepository accountRepository;
    private final RoleRepository roleRepository;
    private final AuthorityRepository authorityRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account =accountRepository.findByEmail(username)
                .orElseThrow(()->new IllegalArgumentException("Not found Email"));
        Role role = roleRepository.findById(account.getRole().getId())
                .orElseThrow(()->new IllegalArgumentException("Not found Email"));
        List<Role> childRolesAndOwnRole = new ArrayList<>(roleRepository.findRoleByParentRole(role));
        childRolesAndOwnRole.add(role);
        List<SimpleGrantedAuthority> authorities = new ArrayList<>(childRolesAndOwnRole
                .stream()
                .flatMap(r->authorityRepository.findByRoles(r)
                        .stream()
                        .distinct())
                .map(a->new SimpleGrantedAuthority(a.getName())).toList());
        return new User(account.getEmail(),account.getPassword(),authorities);
    }
}
