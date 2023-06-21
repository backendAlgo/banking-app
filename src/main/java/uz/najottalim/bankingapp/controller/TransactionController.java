package uz.najottalim.bankingapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import uz.najottalim.bankingapp.dto.TransactionDTO;
import uz.najottalim.bankingapp.service.TransactionService;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("balances")
@Slf4j
public class TransactionController {

    @Autowired
    private TransactionService transactionService;



    @GetMapping("/{id}")
    public ResponseEntity<TransactionDTO> getTransactionById(@PathVariable Long id){
        return transactionService.getTransactionById(id);
    }

    @GetMapping
    public ResponseEntity<TransactionDTO> getAllTransaction(@RequestParam Optional<Integer> pageNum,
                                                            @RequestParam Optional<Integer> pageSize,
                                                            @RequestParam Optional<String> columnName){
        return transactionService.getAllTransaction(columnName,pageNum,pageSize);
    }

    @PutMapping
    public ResponseEntity<TransactionDTO> addTransaction(@RequestBody TransactionDTO transactionDTO){
        return transactionService.addTransaction(transactionDTO);
    }

    @PostMapping
    public ResponseEntity<TransactionDTO> updateTransaction(@RequestBody TransactionDTO transactionDTO){
        return transactionService.updateTransaction(transactionDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TransactionDTO> deleteTransaction(@PathVariable Long id){
        return transactionService.deleteTransaction(id);
    }
}
