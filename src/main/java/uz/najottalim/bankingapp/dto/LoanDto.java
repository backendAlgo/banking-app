package uz.najottalim.bankingapp.dto;

import java.util.Date;

public class LoanDto {
    private Long id;
    private Long accountId;
    private Date startDate;
    private Long loanTypeId;
    private Float totalLoan;
    private Float amountPay;
    private Float outstandingAmt;
}
