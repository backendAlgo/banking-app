package uz.najottalim.bankingapp.servise.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.dto.accountsdto.AccountDto;
import uz.najottalim.bankingapp.repository.AccountRepository;
import uz.najottalim.bankingapp.servise.AccountService;
import uz.najottalim.bankingapp.servise.mapper.AccountMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
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
}
