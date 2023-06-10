package uz.najottalim.bankingapp.servise;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.entity.Account;
import uz.najottalim.bankingapp.repository.AccountRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CostumerUserDetailsService implements UserDetailsService {
    private final AccountRepository accountRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> account = accountRepository.findByEmail(username);
        if(account.isEmpty()) throw new UsernameNotFoundException("No such data found");
        return User.builder()
                .username(account.get().getEmail())
                .password(account.get().getPassword())
                .authorities("default")
                .build();
    }
}
