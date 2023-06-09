package uz.najottalim.bankingapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.najottalim.bankingapp.repository.CardRepository;
import uz.najottalim.bankingapp.service.CardService;

@Service
@RequiredArgsConstructor
public class CardsServiceImpl implements CardService {
    @Autowired
    private CardRepository cardsRepository;
}
