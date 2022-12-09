package com.saccossystemmanagement.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "incomeTable")
@Data
@Getter
@Setter
@NoArgsConstructor
public class ContributionIncome {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private double totalBalance;
    private double totalRegistrationFee;
    private double totalIncome;
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date contributerDate=new Date();

}
