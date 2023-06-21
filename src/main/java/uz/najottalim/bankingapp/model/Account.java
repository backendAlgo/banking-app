package uz.najottalim.bankingapp.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Account {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
    private String email;
    private String mobileNumber;
    private String accountNumber;
    private String address;
    private String password;
    @ManyToOne
    @JoinColumn(name = "account_type_id")
    private AccountType accountType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;




//    id number generated always as identity primary key,
//    name varchar(255),
//    email varchar(255),
//    mobile_number varchar(15),
//    account_number varchar(10),
//    account_type_id number,
//    address varchar(255)
}
