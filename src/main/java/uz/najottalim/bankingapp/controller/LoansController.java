package uz.najottalim.bankingapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.najottalim.bankingapp.dto.LoanDTO;
import uz.najottalim.bankingapp.service.LoansService;

import java.util.List;

@RestController
@RequestMapping("loans")
public class LoansController {

    private LoansService loansService;

    @GetMapping("/{id}")
    public ResponseEntity<LoanDTO> getLoansById(@PathVariable Long id){
        return loansService.getLoansById(id);
    }

    @GetMapping
    public ResponseEntity<List<LoanDTO>> getALLLoans(){
        return loansService.getAllLoans();
    }

    @PostMapping
    public ResponseEntity<LoanDTO> updateLoans(@RequestBody LoanDTO loanDTO){
        return loansService.addLoans(loanDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoanDTO> updateLoans(@RequestBody LoanDTO loanDTO, @PathVariable Long id){
        return loansService.updateLoans(loanDTO, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LoanDTO> deleteLoans(@PathVariable Long id){
        return loansService.deleteLoans(id);
    }
}
