package uz.najottalim.bankingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.entity.Accounts;
import uz.najottalim.bankingapp.repository.AccountRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerUserDetailsService implements UserDetailsService {
    @Autowired
    private AccountRepository accountRepository;

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Accounts account = accountRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("cannot load user: "));
        return new User(account.getEmail(), account.getPassword(),
                new ArrayList<>(List.of(new SimpleGrantedAuthority("default"))));
    }
}
