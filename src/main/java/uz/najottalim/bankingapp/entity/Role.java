package uz.najottalim.bankingapp.entity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Role {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<Authority> authorities;

    @ManyToOne
    @JoinColumn(name = "parent_role_id")
    private Role parentRole;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentRole=" + parentRole +
                '}';
    }
}
