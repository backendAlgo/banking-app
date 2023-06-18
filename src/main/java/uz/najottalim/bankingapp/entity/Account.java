package uz.najottalim.bankingapp.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "account")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
    private String password;
    @ManyToOne
    @JoinColumn(name = "account_type_id")
    private AccountType accountType;

    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
