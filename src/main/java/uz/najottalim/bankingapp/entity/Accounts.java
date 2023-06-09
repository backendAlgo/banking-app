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
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    private String mobileNumber;
    @Column(name = "account_number")
    private String accountNumber;
//    @ManyToMany
//    @JoinColumn(name = "account_type_id")
    private Long accountTypeId;
    private String addres;
//    private AccountType accountType;

}
