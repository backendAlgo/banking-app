package uz.najottalim.bankingapp.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
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
