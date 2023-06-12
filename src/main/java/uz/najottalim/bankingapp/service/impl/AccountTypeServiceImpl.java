package uz.najottalim.bankingapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.model.AccountType;
import uz.najottalim.bankingapp.exception.NoResourceNotFoundException;
import uz.najottalim.bankingapp.repository.AccountTypeRepository;
import uz.najottalim.bankingapp.service.AccountTypeService;

@Service
public class AccountTypeServiceImpl implements AccountTypeService {
    @Autowired
    private AccountTypeRepository accountTypeRepository;

    @Override
    public AccountType findById(Integer id) {
        return accountTypeRepository.findById(id).orElseThrow(() -> new NoResourceNotFoundException("Account type not found"));
    }
}
