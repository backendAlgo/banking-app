package uz.najottalim.bankingapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Messages {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
    private String eamil;
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