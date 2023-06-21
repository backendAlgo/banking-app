package uz.najottalim.bankingapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.najottalim.bankingapp.dto.loanDTO.LoanDto;
import uz.najottalim.bankingapp.service.LoanService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/loans")
public class LoanController {
    private LoanService loanService;
    @GetMapping("/id")
    public ResponseEntity<List<LoanDto>> getById(@PathVariable Long id){
        return loanService.getByAccountId(id);
    }
}
