package uz.najottalim.bankingapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.Dto.AccountsDto;
import uz.najottalim.bankingapp.Dto.TransactionDTO;
import uz.najottalim.bankingapp.Repository.AccountRepository;
import uz.najottalim.bankingapp.Repository.TransactionRepository;
import uz.najottalim.bankingapp.entity.Account;
import uz.najottalim.bankingapp.exception.NoRecurseFoundException;
import uz.najottalim.bankingapp.mapper.TransactionMapper;
import uz.najottalim.bankingapp.service.AccountService;
import uz.najottalim.bankingapp.mapper.AccountMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private  final TransactionRepository transactionRepository;
    @Override
    public ResponseEntity<List<AccountsDto>> getAllAccounts() {
        return ResponseEntity.ok(accountRepository.findAll()
                .stream()
                .map(AccountMapper::toDto)
                .collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<String> addAccount(AccountsDto accountsDto) {
        Account account =AccountMapper.toEntity(accountsDto);
        Account save = accountRepository.save(account);
        return ResponseEntity.ok("saved");
    }

    @Override
    public ResponseEntity<AccountsDto> getAccountById(Long id) {
        Optional<Account> accountOptional = accountRepository.findById(id);
        if (accountOptional.isEmpty()) {
            throw new NoRecurseFoundException("Not found Recourse");
        }
        return ResponseEntity.ok(AccountMapper.toDto(accountOptional.get()));

    }

    @Override
    public ResponseEntity<List<TransactionDTO>> getBalanceByUserId(Long userId) {
        return ResponseEntity.ok(transactionRepository.findByAccount_Id(userId)
                .stream()
                .map(TransactionMapper::toDto)
                .collect(Collectors.toList()));

    }
}
