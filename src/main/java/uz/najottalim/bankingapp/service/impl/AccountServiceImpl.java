package uz.najottalim.bankingapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.dto.accountsDTO.AccountDto;
import uz.najottalim.bankingapp.entity.Accounts;
import uz.najottalim.bankingapp.repository.AccountRepository;
import uz.najottalim.bankingapp.service.AccountService;
import uz.najottalim.bankingapp.service.mapper.AccountMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class AccountServiceImpl implements AccountService, UserDetailsService {
    @Autowired
    private final AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Accounts> accounts = accountRepository.findByEmail(username);
        if (accounts.isEmpty()) throw new UsernameNotFoundException("No such date found");
        return User.builder()
                .username(accounts.get().getEmail())
                .password(accounts.get().getPassword())
                .authorities("default").build();
    }

    @Override
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        return ResponseEntity.ok(accountRepository.findAll()
                .stream()
                .map(AccountMapper::dto)
                .collect(Collectors.toList()));
    }
}
