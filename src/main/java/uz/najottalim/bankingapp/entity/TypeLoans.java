package uz.najottalim.bankingapp.entity;
import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "type_loans")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class TypeLoans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

}
