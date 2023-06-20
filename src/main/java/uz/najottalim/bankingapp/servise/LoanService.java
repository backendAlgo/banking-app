package uz.najottalim.bankingapp.servise;

import org.springframework.http.ResponseEntity;
import uz.najottalim.bankingapp.dto.loandto.LoanDto;
import java.util.*;

public interface LoanService {
    ResponseEntity<List<LoanDto>> geByAccountId(Long id);
}
