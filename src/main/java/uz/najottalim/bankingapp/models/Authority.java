package uz.najottalim.bankingapp.models;

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
@Table(name = "authorities")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "roles_authority",
            joinColumns = {@JoinColumn(table = "authorities", referencedColumnName = "id", name = "auth_id")},
            inverseJoinColumns = {
                    @JoinColumn(table = "roles", referencedColumnName = "id", name = "role_id")})
    private List<Role> roles;

}
