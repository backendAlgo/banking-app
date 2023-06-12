package uz.najottalim.bankingapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "type_loans")
@Data
public class LoanType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
}
