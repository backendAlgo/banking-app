package uz.najottalim.bankingapp.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.dto.AccountDto;
import uz.najottalim.bankingapp.entity.Account;
import uz.najottalim.bankingapp.mapper.AccountMapping;
import uz.najottalim.bankingapp.repository.AccountRepository;
import uz.najottalim.bankingapp.service.AccountService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final AccountMapping accountMapping = new AccountMapping();


    @Override
    public ResponseEntity<AccountDto> findById(Long id) {
        Optional<Account> byId = accountRepository.findById(id);
        if (byId.isEmpty()){

        }
        return ResponseEntity.ok(accountMapping.toDto(byId.get()));
    }

    @Override
    public ResponseEntity<List<AccountDto>> findAll() {
        List<Account> all = accountRepository.findAll();
        return ResponseEntity.ok(all.stream().map(accountMapping::toDto).toList());
    }

    @Override
    public ResponseEntity<AccountDto> save(AccountDto accountDto) {
        if (accountDto == null){
            return null;
        }
        return ResponseEntity.ok(accountMapping.toDto(accountRepository.save(accountMapping.toEntity(accountDto))));
    }

    @Override
    public void delete(Long id) {
        Optional<Account> byId = accountRepository.findById(id);
        if (byId.isEmpty()) {

        } else {
            System.out.println(accountMapping.toDto(byId.get()));
            accountRepository.delete(byId.get());
        }
    }

    @Override
    public ResponseEntity<AccountDto> update(AccountDto accountDto) {
        Optional<Account> byId = accountRepository.findById(accountDto.getId());
        if (byId.isEmpty()){
            return null;
        }
        return null;
    }
}
