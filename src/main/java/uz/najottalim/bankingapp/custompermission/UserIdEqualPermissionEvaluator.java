package uz.najottalim.bankingapp.custompermission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import uz.najottalim.bankingapp.repository.AccountRepository;

import java.io.Serializable;

@Component
public class UserIdEqualPermissionEvaluator implements PermissionEvaluator {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public boolean hasPermission(Authentication auth, Object targetDomainObject, Object permission) {
        if ((auth == null) || (targetDomainObject == null) || !(permission instanceof String)) {
            return false;
        }

        return hasPrivilege(auth, (Long)targetDomainObject);
    }

    private boolean hasPrivilege(Authentication auth, Long userId) {
        return accountRepository.findById(userId)
                .map(account -> {
                    return auth.getName().equals(account.getName());
                }).orElse(false);
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        return false;
    }
}
