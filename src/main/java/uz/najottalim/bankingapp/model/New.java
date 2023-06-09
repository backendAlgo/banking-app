package uz.najottalim.bankingapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "news")
public class New {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String title;
    private String body;
    private String imageUrl;
    private LocalDate sentDate;

//    title varchar(255),
//    body varchar2(4000),
//    image_url varchar(255),
//    create_date date,
}