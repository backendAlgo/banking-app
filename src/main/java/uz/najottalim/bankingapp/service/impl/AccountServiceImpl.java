package uz.najottalim.bankingapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.dto.AccountDTO;
import uz.najottalim.bankingapp.mapper.AccountMapper;
import uz.najottalim.bankingapp.models.Account;
import uz.najottalim.bankingapp.repository.AccountRepository;
import uz.najottalim.bankingapp.service.AccountService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Override
    public ResponseEntity<AccountDTO> getAccountById(Long id) {
        Optional<Account> accountOptional = accountRepository.findById(id);
        if (accountOptional.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(accountMapper.toDto(accountOptional.get()));
    }

    @Override
    public ResponseEntity<List<AccountDTO>> getAllAccount(Optional<String> columnName, Optional<Integer> page, Optional<Integer> size) {
        Pageable pageRequest = null;
        Sort sort = null;
        if (page.isPresent() && size.isPresent()) {
            pageRequest = PageRequest.of(page.get(), size.get(), Sort.by("id"));
        }
        if (pageRequest == null) {
            return ResponseEntity.ok(accountRepository.findAll(Sort.by("id")).stream()
                    .map(accountMapper::toDto)
                    .collect(Collectors.toList()));
        }
        return ResponseEntity.ok(accountRepository.findAll(pageRequest).stream()
                .map(accountMapper::toDto)
                .collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<AccountDTO> addAccount(AccountDTO accountDTO) {
        if(accountDTO == null) {
            throw new NoSuchElementException("account not found");
        }
        Account account = accountRepository.save(accountMapper.toEntity(accountDTO));
        return ResponseEntity.ok(accountMapper.toDto(account));
    }

    @Override
    public ResponseEntity<AccountDTO> updateAccount(AccountDTO accountDTO, Long id) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        if (optionalAccount.isEmpty()){
            throw new NoSuchElementException("account not found");
        }
        accountDTO.setId(id);
        return ResponseEntity.ok(accountMapper
                .toDto(accountRepository
                        .save(accountMapper
                                .toEntity(accountDTO))));
    }

    @Override
    public ResponseEntity<AccountDTO> deleteAccount(Long id) {
        Optional<Account> accountOptional = accountRepository.findById(id);
        if(accountOptional.isEmpty()){
            throw new NoSuchElementException("account not found");
        }
        accountRepository.delete(accountOptional.get());
        return ResponseEntity.ok(accountMapper.toDto(accountOptional.get()));
    }

}
