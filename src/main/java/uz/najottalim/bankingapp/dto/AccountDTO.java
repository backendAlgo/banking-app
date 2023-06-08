package uz.najottalim.bankingapp.dto;
import lombok.*;

import javax.persistence.*;
public class AccountDTO {
    private Long id;
    private String name;
    private String email;
    private String mobileNumber;
    private String accountNumber;
    private Long accountTypeId;
    private String address;

    // Constructors, getters, and setters
}

