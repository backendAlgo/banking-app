package uz.najottalim.bankingapp.entity;

import jakarta.persistence.*;
import jdk.dynalink.linker.LinkerServices;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class StatusType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "statusType")
    private List<Messages> messages;
}
