package uz.najottalim.bankingapp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String subject;
    private String message;
    @Column(name = "send_date")
    private LocalDate sendDate;

    @ManyToOne
    @JoinColumn(name = "status_type_id")
    private StatusType statusType;

}
