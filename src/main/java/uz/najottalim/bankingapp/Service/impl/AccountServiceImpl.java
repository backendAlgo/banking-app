package uz.najottalim.bankingapp.Service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.Entity.Account;
import uz.najottalim.bankingapp.Entity.Authority;
import uz.najottalim.bankingapp.Entity.Role;
import uz.najottalim.bankingapp.Service.AccountService;
import uz.najottalim.bankingapp.dto.TransactionDto;
import uz.najottalim.bankingapp.exeption.NoResourceFoundException;
import uz.najottalim.bankingapp.mapper.TransactionMapper;
import uz.najottalim.bankingapp.repository.AccountRepository;
import uz.najottalim.bankingapp.dto.AccountDto;
import uz.najottalim.bankingapp.mapper.AccountMapper;
import uz.najottalim.bankingapp.repository.AuthorityRepository;
import uz.najottalim.bankingapp.repository.RoleRepository;
import uz.najottalim.bankingapp.repository.TransactionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService, UserDetailsService {

    private final AccountRepository accountRepository;
    final private RoleRepository roleRepository;
    private final AuthorityRepository authorityRepository;
    private final TransactionRepository transactionRepository;


    @Override
    public ResponseEntity<AccountDto> getById(Long id) {
        Optional<Account> account = accountRepository.findById(id);
        if(account.isEmpty()){
            throw new NoResourceFoundException("No data found");
        }
        return ResponseEntity.ok(AccountMapper.toDto(account.get()));
    }

    @Override
    public ResponseEntity<List<TransactionDto>> getBalanceById(Long id) {
        return ResponseEntity.ok(transactionRepository.findByAccount_Id(id).stream()
                .map(TransactionMapper::toDto).collect(Collectors.toList())
        );
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

            Account account = accountRepository.findByEmail(email)
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
}
