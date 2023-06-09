package uz.najottalim.bankingapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.repository.LoansRepository;
import uz.najottalim.bankingapp.service.LoansService;

@Service
@RequiredArgsConstructor
public class LoansServiceImpl implements LoansService {

    @Autowired
    private LoansRepository creditsRepository;
}
