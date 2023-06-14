package uz.najottalim.bankingapp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.najottalim.bankingapp.models.Authority;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
public class Role {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;

    @OneToMany
    private List<Authority> authorities;

    @ManyToOne
    @JoinColumn(name = "parent_role_id")
    private Role parentRole;

//    @OneToMany(mappedBy = "parentRole")
//    private List<Role> childRoles;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentRole=" + parentRole +
                '}';
    }
}
