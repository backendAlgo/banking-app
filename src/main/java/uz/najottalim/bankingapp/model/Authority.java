package uz.najottalim.bankingapp.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "authority")
@Data
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;
}
