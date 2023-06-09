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
@Table(name = "messages")
public class Message {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
    private String email;
    private String subject;
    private String message;
    private LocalDate sentDate;

//    name varchar(255),
//    email varchar(255),
//    subject varchar(255),
//    message varchar2(4000),
//    sent_date date,
//    status_type_id number,
//    primary key (id)
}