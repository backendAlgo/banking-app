package uz.najottalim.bankingapp.dto.messagedto;

import jakarta.persistence.ManyToOne;
import uz.najottalim.bankingapp.entity.MassagesStatusType;

import java.time.LocalDate;

public class MessageDto {
    private Long id;
    private String name;
    private String email;
    private String subject;
    private String message;
    private LocalDate sentDate;

    private MassagesStatusTypeDto statusTypeDto;
}
