package uz.najottalim.bankingapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    @Column(name = "mobile_number")
    private String mobileNumber;
    @Column(name = "account_number")
    private String accountNumber;
    @ManyToOne
    @JoinColumn(name = "account_type_id",nullable = false)
    private AccountType accountType;
    private String address;
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;
}
