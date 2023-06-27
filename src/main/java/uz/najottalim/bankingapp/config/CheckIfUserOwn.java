package uz.najottalim.bankingapp.config;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.repository.AccountRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class CheckIfUserOwn {
    private final AccountRepository accountRepository;

    public boolean check(Long userId) {
        Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();
        log.info("currently checking userId: {}", userId);
        return accountRepository.findById(userId)
                .map(account -> account.getEmail()
                        .equals(authentication.getName()))
                .orElse(false);
    }
}
