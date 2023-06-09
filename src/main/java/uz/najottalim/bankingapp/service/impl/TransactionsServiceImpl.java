package uz.najottalim.bankingapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.repository.TransactionsRepository;
import uz.najottalim.bankingapp.service.TransactionsService;

@Service
@RequiredArgsConstructor
public class TransactionsServiceImpl implements TransactionsService {
    @Autowired
    private TransactionsRepository balanceRepository;
}
