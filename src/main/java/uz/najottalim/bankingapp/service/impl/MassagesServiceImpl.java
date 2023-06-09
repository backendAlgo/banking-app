package uz.najottalim.bankingapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.repository.MassagesRepository;
import uz.najottalim.bankingapp.service.MassageService;

@Service
@RequiredArgsConstructor
public class MassagesServiceImpl implements MassageService {

    @Autowired
    private MassagesRepository massagesRepository;
}
