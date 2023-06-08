package uz.najottalim.bankingapp.entity;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "loans")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(name = "start_date")
    private Date startDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_loans_id")
    private TypeLoans typeLoans;

    @Column(name = "total_loan")
    private Float totalLoan;

    @Column(name = "amount_pay")
    private Float amountPay;

    @Column(name = "outstanding_amt")
    private Float outstandingAmt;
}
