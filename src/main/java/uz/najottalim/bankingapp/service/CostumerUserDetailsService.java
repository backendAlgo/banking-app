package uz.najottalim.bankingapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.Repository.AccountRepository;
import uz.najottalim.bankingapp.entity.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CostumerUserDetailsService implements UserDetailsService {
    private  final AccountRepository accountRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account =accountRepository.findByEmail(username)
                .orElseThrow();
        return User.builder()
                .username(account.getEmail())
                .password(account.getPassword())
                .authorities(account.getRole().getName())
                .build();
    }
}
