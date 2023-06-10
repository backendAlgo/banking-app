package uz.najottalim.bankingapp.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.najottalim.bankingapp.dto.LoanDTO;
import uz.najottalim.bankingapp.service.LoansService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("loans")
@Slf4j
@RequiredArgsConstructor
public class LoansController {

    private final LoansService loansService;

    @GetMapping("/{id}")
    public ResponseEntity<LoanDTO> getLoansById(@PathVariable Long id){
        return loansService.getLoansById(id);
    }

    @GetMapping
    public ResponseEntity<List<LoanDTO>> getALLLoans(@RequestParam Optional<Integer> pageNum,
                                                     @RequestParam Optional<Integer> pageSize,
                                                     @RequestParam Optional<String> columnName){
        return loansService.getAllLoans(columnName,pageNum,pageSize);
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
