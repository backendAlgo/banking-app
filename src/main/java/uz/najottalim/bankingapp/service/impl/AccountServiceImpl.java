package uz.najottalim.bankingapp.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.dto.AccountDTO;
import uz.najottalim.bankingapp.dto.TransactionDTO;
import uz.najottalim.bankingapp.exceptions.NoResourceFoundException;
import uz.najottalim.bankingapp.mapper.AccountMapper;
import uz.najottalim.bankingapp.mapper.TransactionMapper;
import uz.najottalim.bankingapp.models.Account;
import uz.najottalim.bankingapp.models.Authority;
import uz.najottalim.bankingapp.models.Role;
import uz.najottalim.bankingapp.repository.AccountRepository;
import uz.najottalim.bankingapp.repository.AuthorityRepository;
import uz.najottalim.bankingapp.repository.RoleRepository;
import uz.najottalim.bankingapp.repository.TransactionRepository;
import uz.najottalim.bankingapp.service.AccountService;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService, UserDetailsService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    private final TransactionMapper transactionMapper;
    private final PasswordEncoder passwordEncoder;
    final private RoleRepository roleRepository;
    final private AuthorityRepository authorityRepository;
    final private TransactionRepository transactionRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = (Account) accountRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("cannot load user: "));

        Role role = roleRepository.findById(account.getRole().getId())
                .orElseThrow(() -> new IllegalArgumentException("Role not found"));

        List<Role> childRolesAndOwnRole = new ArrayList<>(roleRepository.findRoleByParentRole(role));
        childRolesAndOwnRole.add(role);

        List<SimpleGrantedAuthority> allAuthorities = childRolesAndOwnRole
                .stream()
                .flatMap(roleItem -> Stream.concat(
                        Stream.of(roleItem.getName()),
                        authorityRepository.findByRole(roleItem)
                                .stream()
                                .map(Authority::getName)))
                .map(SimpleGrantedAuthority::new)
                .toList();

        return new User(account.getEmail(), account.getPassword(), allAuthorities);
    }

    @Override
    public ResponseEntity<AccountDTO> getAccountById(Long id) {
//        log.info("authenticate: {}", SecurityContextHolder.getContext().getAuthentication());
//        log.info("Username: {}", SecurityContextHolder.getContext().getAuthentication().getName());
        Optional<Account> accountOptional = accountRepository.findById(id);
        if (accountOptional.isEmpty()) {
            throw new NoResourceFoundException();
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
        if (accountDTO == null) {
            throw new NoSuchElementException("account not found");
        }
        AccountDTO passwordChangedAccount = accountDTO.withPassword(passwordEncoder.encode(accountDTO.password()));


        Account account = accountRepository.save(accountMapper.toEntity(passwordChangedAccount));

        return ResponseEntity.ok(accountMapper.toDto(account));
    }

    @Override
    public ResponseEntity<AccountDTO> updateAccount(AccountDTO accountDTO, Long id) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        if (optionalAccount.isEmpty()) {
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
        if (accountOptional.isEmpty()) {
            throw new NoSuchElementException("account not found");
        }
        accountRepository.delete(accountOptional.get());
        return ResponseEntity.ok(accountMapper.toDto(accountOptional.get()));
    }

    @Override
    public ResponseEntity<List<TransactionDTO>> getBalanceByUserId(Long userId) {
        return ResponseEntity.ok(transactionRepository.findByAccount_IdOrderByTransactionDateDesc(userId)
                .stream()
                .map(transactionMapper::toDto)
                .collect(Collectors.toList()));
    }


}
