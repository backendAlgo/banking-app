package uz.najottalim.bankingapp.servise.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.dto.accountsdto.AccountDto;
import uz.najottalim.bankingapp.entity.Account;
import uz.najottalim.bankingapp.entity.Role;
import uz.najottalim.bankingapp.exception.LimitAccessException;
import uz.najottalim.bankingapp.exception.NoResourceFoundException;
import uz.najottalim.bankingapp.repository.AccountRepository;
import uz.najottalim.bankingapp.repository.RoleRepository;
import uz.najottalim.bankingapp.servise.AccountService;
import uz.najottalim.bankingapp.servise.mapper.AccountMapper;
import uz.najottalim.bankingapp.servise.mapper.RoleMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService, UserDetailsService {
    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder ;
    @Override
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
         return ResponseEntity.ok(
                 accountRepository.findAll()
                 .stream()
                 .map(AccountMapper::toDto)
                 .collect(Collectors.toList())
         );
    }

    @Override
    public ResponseEntity<AccountDto> getById(Long id) {
        Optional<Account> account = accountRepository.findById(id);
        Account account1 = account.orElseThrow(NoResourceFoundException::new);

        if (
                !SecurityContextHolder.getContext().getAuthentication().getName()
                .equals(account1.getEmail()
                )) throw new LimitAccessException("Access limitation");

        return ResponseEntity.ok(AccountMapper.toDto(account1));
    }

    @Override
    public ResponseEntity<AccountDto> addAccount(AccountDto accountDto) {

        Role defaoultRole = roleRepository.
                findById(1).
                orElseThrow(()->new NoResourceFoundException("No default Role found"));

        if(accountDto.getRoleDto() == null){
            accountDto.setRoleDto(
                    RoleMapper.toDtoWithAuthorities(defaoultRole));
        }
        accountDto.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        return ResponseEntity.ok(AccountMapper.toDto(accountRepository.save(AccountMapper.toEntity(accountDto))));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository
                .findByEmail(username).orElseThrow(()->new UsernameNotFoundException("user not found"));
        return User.builder()
                .username(account.getEmail())
                .password(account.getPassword())
                .authorities(account.getRole().getName())
                .build();
    }
}
