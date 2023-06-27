package uz.najottalim.bankingapp.custompermission;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.repository.AccountRepository;

import java.io.Serializable;

@Service
@Slf4j
@RequiredArgsConstructor

public class UserIdEqualPermissionEvaluator implements PermissionEvaluator {
    private final AccountRepository accountRepository;


    @Override
    public boolean hasPermission(Authentication authentication, Object target, Object permission) {
        log.info("Denying user {} permission '{}' on object {}", authentication.getName(),
                permission, target);
        if (target instanceof Long userId) {
//            Long userId = (Long) target;
            return accountRepository.findById(userId)
                    .map(account -> account.getEmail()
                            .equals(authentication.getName()))
                    .orElse(false);
        }
        return false;
    }


    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        return false;
    }
}
