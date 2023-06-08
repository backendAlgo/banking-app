package uz.najottalim.bankingapp.entity;
import lombok.*;
import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "news")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "body", length = 4000)
    private String body;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "create_date")
    private Date createDate;
}
