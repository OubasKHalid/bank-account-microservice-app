package org.khalid.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import org.khalid.accountservice.enums.AccountType;
import org.khalid.accountservice.model.Customer;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class BankAccount {
    @Id
    private String accountId;
    private  double balance;
    private LocalDate createAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    private Long customerId;
    @Transient
    private Customer customer;


}

