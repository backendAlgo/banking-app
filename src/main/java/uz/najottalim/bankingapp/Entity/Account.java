package uz.najottalim.bankingapp.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.najottalim.bankingapp.Entity.AccountType;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String mobileNumber;
    private String accountNumber;

    @ManyToOne
    @JoinColumn(name = "account_type_id")
    private AccountType accountType;
    private String address;

    @ManyToOne
    private Role role;

}