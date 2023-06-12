package uz.najottalim.bankingapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "authorities")
public class Authority {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "roles_authority",
            joinColumns = {@JoinColumn(table = "authorities", referencedColumnName = "id", name = "auth_id")},
            inverseJoinColumns = {
                    @JoinColumn(table = "roles", referencedColumnName = "id", name = "role_id")})
    private List<Role> roles;

}
