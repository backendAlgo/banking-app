package uz.najottalim.bankingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uz.najottalim.bankingapp.model.Customer;
import uz.najottalim.bankingapp.repository.CustomerRepository;

@RestController
public class LoginController {
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
        try {
            customerRepository.save(customer);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("New User successfully registered");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occured due to " + ex.getMessage());
        }
    }
}
