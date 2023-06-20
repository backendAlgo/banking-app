package uz.najottalim.bankingapp.entity;

import ch.qos.logback.classic.model.LoggerModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.najottalim.bankingapp.Dto.AccountTypeDto;

@Entity
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String mobileNumber;
    private String accountNumber;
    @ManyToOne
    @JoinColumn(name = "account_type_id", nullable = false)
    private AccountType accountType;
    private String address;
    private String password;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role roles;

}
