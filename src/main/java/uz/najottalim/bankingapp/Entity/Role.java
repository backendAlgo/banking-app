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
@Table(name = "roles")
public class Role {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
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
