package uz.najottalim.bankingapp.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.dto.AccountDTO;
import uz.najottalim.bankingapp.mapper.AccountMapper;
import uz.najottalim.bankingapp.models.Account;
import uz.najottalim.bankingapp.repository.AccountRepository;
import uz.najottalim.bankingapp.service.AccountService;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = (Account) accountRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("cannot load user: "));

//       TODO: 1. berilgan userni email bo'yicha oling, role_id mas
//       TODO: 2. role_iddan foydalanib, hamma authoritielarni oling
        List<String> authorities = new ArrayList<>();
//        GrantedAuthority
        return new User(account.getEmail(), account.getPassword(),
                authorities.stream().map(
                                SimpleGrantedAuthority::new
                        )
                        .collect(Collectors.toList())
        );
    }

    @Override
    public ResponseEntity<AccountDTO> getAccountById(Long id) {
//        log.info("authenticate: {}", SecurityContextHolder.getContext().getAuthentication());
//        log.info("Username: {}", SecurityContextHolder.getContext().getAuthentication().getName());
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
        AccountDTO passwordChangedAccount = accountDTO.withPassword(passwordEncoder.encode(accountDTO.password()));


        Account account = accountRepository.save(accountMapper.toEntity(passwordChangedAccount));

        return ResponseEntity.ok(accountMapper.toDto(account));
    }

    @Override
    public ResponseEntity<AccountDTO> updateAccount(AccountDTO accountDTO, Long id) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        if (optionalAccount.isEmpty()){
            throw new NoSuchElementException("account not found");
        }
        accountDTO.withId(id);
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
