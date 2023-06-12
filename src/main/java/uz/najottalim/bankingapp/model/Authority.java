package uz.najottalim.bankingapp.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "authority")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToMany(mappedBy = "authorities")
    private List<Role> roles;
}
