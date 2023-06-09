package uz.najottalim.bankingapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.repository.CardsRepository;
import uz.najottalim.bankingapp.service.CardsService;

@Service
@RequiredArgsConstructor
public class CardsServiceImpl implements CardsService {
    @Autowired
    private CardsRepository cardsRepository;
}
