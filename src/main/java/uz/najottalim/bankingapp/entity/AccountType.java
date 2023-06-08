package uz.najottalim.bankingapp.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "account_type")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class AccountType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

}
