package uz.najottalim.bankingapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.hibernate.exception.LockAcquisitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.dto.accountsDTO.AccountDto;
import uz.najottalim.bankingapp.entity.Accounts;
import uz.najottalim.bankingapp.entity.Role;
import uz.najottalim.bankingapp.exception.NoResourceFoundException;
import uz.najottalim.bankingapp.repository.AccountRepository;
import uz.najottalim.bankingapp.repository.RoleRepository;
import uz.najottalim.bankingapp.service.AccountService;
import uz.najottalim.bankingapp.service.mapper.AccountMapper;
import uz.najottalim.bankingapp.service.mapper.RoleMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class AccountServiceImpl implements AccountService, UserDetailsService {
    @Autowired
    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder ;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Accounts> accounts = accountRepository.findByEmail(username);
        if (accounts.isEmpty()) throw new UsernameNotFoundException("No such date found");
        return User.builder()
                .username(accounts.get().getEmail())
                .password(accounts.get().getPassword())
                .authorities("default").build();
    }

    @Override
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        return ResponseEntity.ok(accountRepository.findAll()
                .stream()
                .map(AccountMapper::dto)
                .collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<AccountDto> getById(Long id) {
        Optional<Accounts> account = accountRepository.findById(id);
        Accounts account1 = account.orElseThrow(NoResourceFoundException::new);

        if (
                !SecurityContextHolder.getContext().getAuthentication().getName()
                        .equals(account1.getEmail()
                        )) throw new LockAcquisitionException("Access limitation");

        return ResponseEntity.ok(AccountMapper.dto(account1));
    }

    @Override
    public ResponseEntity<AccountDto> addAccount(AccountDto accountDto) {
        Role defaoultRole = roleRepository.
                findById(1L).
                orElseThrow(()->new NoResourceFoundException("No default Role found"));

        if(accountDto.getRoleDto() == null){
            accountDto.setRoleDto(
                    RoleMapper.toDtoWithAuthorities(defaoultRole));
        }
        accountDto.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        return ResponseEntity.ok(AccountMapper.dto(accountRepository.save(AccountMapper.toEntity(accountDto))));
    }
}
