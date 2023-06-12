package uz.najottalim.bankingapp.servise.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.dto.accountsdto.AccountDto;
import uz.najottalim.bankingapp.entity.Account;
import uz.najottalim.bankingapp.exception.NoResourceFoundException;
import uz.najottalim.bankingapp.repository.AccountRepository;
import uz.najottalim.bankingapp.servise.AccountService;
import uz.najottalim.bankingapp.servise.mapper.AccountMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService, UserDetailsService {
    private final AccountRepository accountRepository;
    @Override
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
         return ResponseEntity.ok(
                 accountRepository.findAll()
                 .stream()
                 .map(AccountMapper::toDto)
                 .collect(Collectors.toList())
         );
    }

    @Override
    public ResponseEntity<AccountDto> getById(Long id) {
        Optional<Account> account = accountRepository.findById(id);
        Account account1 = account.orElseThrow(NoResourceFoundException::new);
        return ResponseEntity.ok(AccountMapper.toDto(account1));
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByEmail(username).orElseThrow();
        return User.builder()
                .username(account.getEmail())
                .password(account.getPassword())
                .authorities(account.getRole().getName())
                .build();
    }
}
