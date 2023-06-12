package uz.najottalim.bankingapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "accounts")
public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    @Column(name = "mobil_number")
    private String mobileNumber;
    @Column(name = "account_number")
    private String accountNumber;
    private Long accountTypeId;
    @ManyToOne
    private AccountType accountType;
    private String addres;
    @ManyToOne
    private Role role;
}
