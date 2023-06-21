package uz.najottalim.bankingapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.dto.AccountDTO;
import uz.najottalim.bankingapp.dto.RoleDTO;
import uz.najottalim.bankingapp.dto.TransactionDTO;
import uz.najottalim.bankingapp.exceptions.NoResourceFoundException;
import uz.najottalim.bankingapp.mapper.AccountMapper;
import uz.najottalim.bankingapp.mapper.TransactionMapper;
import uz.najottalim.bankingapp.model.Account;
import uz.najottalim.bankingapp.model.Authority;
import uz.najottalim.bankingapp.model.Role;
import uz.najottalim.bankingapp.repository.AccountRepository;
import uz.najottalim.bankingapp.repository.AuthorityRepository;
import uz.najottalim.bankingapp.repository.RoleRepository;
import uz.najottalim.bankingapp.repository.TransactionRepository;
import uz.najottalim.bankingapp.service.AccountService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService, UserDetailsService {
    final private AccountRepository accountRepository;
    final private RoleRepository roleRepository;
    final private AuthorityRepository authorityRepository;
    final private TransactionRepository transactionRepository;


    @Override
    public ResponseEntity<List<AccountDTO>> getAllAccounts() {
        List<Account> all = accountRepository.findAll();
        return ResponseEntity.ok(all.stream().map(AccountMapper::toDto).collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<AccountDTO> addAccount(AccountDTO accountDTO) {
        Account account = AccountMapper.toEntity(accountDTO);
        Account account1 = accountRepository.save(account);

        return ResponseEntity.ok(AccountMapper.toDto(account1));
    }

    @Override
    public ResponseEntity<AccountDTO> getById(Long id) {
        Optional<Account> account = accountRepository.findById(id);
        if(account.isEmpty()){
            throw new NoResourceFoundException("Not Data Found");
        }
        return ResponseEntity.ok(AccountMapper.toDto(account.get()));
    }

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
    public ResponseEntity<List<TransactionDTO>> getBalanceByUserId(Long userId) {
        return ResponseEntity.ok(transactionRepository.findByAccount_Id(userId)
                .stream()
                .map(TransactionMapper ::toDto)
                .collect(Collectors.toList()));
    }
}
