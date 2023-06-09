package uz.najottalim.bankingapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.najottalim.bankingapp.dto.LoansDTO;
import uz.najottalim.bankingapp.service.LoansService;

import java.util.List;

@RestController
@RequestMapping("loans")
public class LoansController {

    private LoansService loansService;

    @GetMapping("/{id}")
    public ResponseEntity<LoansDTO> getLoansById(@PathVariable Long id){
        return loansService.getLoansById(id);
    }

    @GetMapping
    public ResponseEntity<List<LoansDTO>> getALLLoans(){
        return loansService.getAllLoans();
    }

    @PostMapping
    public ResponseEntity<LoansDTO> updateLoans(@RequestBody LoansDTO loansDTO){
        return loansService.addLoans(loansDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoansDTO> updateLoans(@RequestBody LoansDTO loansDTO, @PathVariable Long id){
        return loansService.updateLoans(loansDTO, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LoansDTO> deleteLoans(@PathVariable Long id){
        return loansService.deleteLoans(id);
    }
}
