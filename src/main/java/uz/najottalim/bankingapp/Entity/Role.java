package uz.najottalim.bankingapp.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "role")
public class Role {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    String name;

    @ManyToMany(mappedBy = "roles")
    private List<Authority> authorities;

    @ManyToOne
    @JoinColumn(name = "parent_role_id")
    private Role parenRole;
}
