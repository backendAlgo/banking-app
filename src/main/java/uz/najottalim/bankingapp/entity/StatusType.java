package uz.najottalim.bankingapp.entity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "status_type")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class StatusType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

}
