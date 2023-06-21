package uz.najottalim.bankingapp.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.najottalim.bankingapp.dto.LoanDTO;
import uz.najottalim.bankingapp.service.LoanService;

import java.util.List;

@RestController
@RequestMapping("/loans")
@Slf4j
@RequiredArgsConstructor
public class LoansController {
    private final LoanService loanService;
    @GetMapping("{id}")
    public ResponseEntity<List<LoanDTO>> getById(@PathVariable Long id){
        return loanService.getById(id);
    }
}
