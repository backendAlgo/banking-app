package uz.najottalim.bankingapp.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
    private String email;
    private String mobileNumber;
    private String accountNumber;
    private String address;
    @OneToMany
    @JoinColumn(name = "account")
    private AccountType accountType;
}
