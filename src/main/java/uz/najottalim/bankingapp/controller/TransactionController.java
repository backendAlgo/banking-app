package uz.najottalim.bankingapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.najottalim.bankingapp.dto.transactiondto.TransactionDto;
import uz.najottalim.bankingapp.servise.TransactionService;

import java.util.*;

@RestController
@RequestMapping("/balances")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;
    @GetMapping("/{id}")
    public ResponseEntity<List<TransactionDto>> getByAccountId(@PathVariable Long id){
        return transactionService.getByAccountId(id);
    }
}
