package uz.najottalim.bankingapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class AccountType {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;

<<<<<<< HEAD
=======


//    id number generated always as identity,
//    name varchar(255),
//    primary key (id)
>>>>>>> 898856bb5b024bfdc0280f323c6babf2b445cf88
}
