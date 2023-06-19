package uz.najottalim.bankingapp.entity;

import ch.qos.logback.classic.model.LoggerModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String mobileNumber;
    private String accountNumber;
    @ManyToOne
    @JoinColumn(name = "account_type_id",nullable = false)
    private AccountType accountType;
    private String address;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role roles;


    public Account(Long id, String name, String email, String password,
                   String mobileNumber, String accountNumber, String address, AccountType entity, Role role) {
        this.id=id;
        this.name=name;
        this.email=email;
        this.address =address;
        this.accountType =entity;
        this.password=password;
        this.mobileNumber=mobileNumber;
        this.accountNumber=accountNumber;
        this.roles=role;
    }
}
