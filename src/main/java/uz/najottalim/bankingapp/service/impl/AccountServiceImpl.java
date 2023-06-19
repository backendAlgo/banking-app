package uz.najottalim.bankingapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.dto.AccountDto;
import uz.najottalim.bankingapp.mapper.AccountMapper;
import uz.najottalim.bankingapp.entity.Account;
import uz.najottalim.bankingapp.repository.AccountRepository;
import uz.najottalim.bankingapp.service.AccountsService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountsService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Override
    public ResponseEntity<AccountDto> getAccountById(Long id) {
        Optional<Account> accountOptional = accountRepository.findById(id);
        if (accountOptional.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(accountMapper.toDto(accountOptional.get()));
    }


    @Override
    public ResponseEntity<AccountDto> addAccount(AccountDto accountDTO) {
        if(accountDTO == null) {
            throw new NoSuchElementException("account not found");
        }
        Account account = (Account) accountRepository.save(accountMapper.toEntity(accountDTO));
        return ResponseEntity.ok(accountMapper.toDto(account));
    }

    @Override
    public ResponseEntity<AccountDto> updateAccount(AccountDto accountDTO, Long id) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        if (optionalAccount.isEmpty()){
            throw new NoSuchElementException("account not found");
        }
        accountDTO.setId(id);
        return ResponseEntity.ok(accountMapper
                .toDto((Account) accountRepository
                        .save(accountMapper
                                .toEntity(accountDTO))));
    }

    @Override
    public ResponseEntity<AccountDto> deleteAccount(Long id) {
        Optional<Account> accountOptional = accountRepository.findById(id);
        if(accountOptional.isEmpty()){
            throw new NoSuchElementException("account not found");
        }
        accountRepository.delete(accountOptional.get());
        return ResponseEntity.ok(accountMapper.toDto(accountOptional.get()));
    }

}