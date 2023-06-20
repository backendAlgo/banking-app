package uz.najottalim.bankingapp.dto.messagedto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDto {
    /*
  public contactId: string;
  public contactName: string;
  public contactEmail: string;
  public subject: string;
  public message: string;
  * */
    @JsonProperty(value = "contactId")
    private Long id;
    @JsonProperty(value = "contactName")
    private String name;
    @JsonProperty(value = "contactEmail")
    private String email;
    private String subject;
    private String message;
    private LocalDate sentDate;
}
