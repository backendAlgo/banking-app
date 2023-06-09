package uz.najottalim.bankingapp.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String name;
    private String email;
    private String mobileNumber;
    private String accountNumber;
    private Integer accountTypeId;
    private String address;

}
