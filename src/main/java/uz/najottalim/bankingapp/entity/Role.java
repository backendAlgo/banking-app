package uz.najottalim.bankingapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class  Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "roles")
    private List<Authority> authorities;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    private List<Account> accounts;

    @ManyToOne
    @JoinColumn(name = "parent_role_id")
    private Role parentRole;


    public Role(Long id, String name) {
        this.id=id;
        this.name=name;
    }
}