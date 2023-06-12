package uz.najottalim.bankingapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.Dto.AccountsDto;
import uz.najottalim.bankingapp.Repository.AccountRepository;
import uz.najottalim.bankingapp.service.AccountService;
import uz.najottalim.bankingapp.service.mapper.AccountMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    @Override
    public ResponseEntity<List<AccountsDto>> getAllAccounts() {
        return ResponseEntity.ok(accountRepository.findAll()
                .stream()
                .map(AccountMapper::toDto)
                .collect(Collectors.toList()));
    }
}
