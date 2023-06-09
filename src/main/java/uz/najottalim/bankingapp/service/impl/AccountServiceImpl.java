package uz.najottalim.bankingapp.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.dto.AccountDto;
import uz.najottalim.bankingapp.entity.Account;
import uz.najottalim.bankingapp.mapper.AccountMapping;
import uz.najottalim.bankingapp.repository.AccountRepository;
import uz.najottalim.bankingapp.service.AccountService;

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
}
