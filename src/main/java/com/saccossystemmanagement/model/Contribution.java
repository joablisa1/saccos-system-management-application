package com.saccossystemmanagement.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "contribution")
@Data
@NoArgsConstructor
@Getter
@Setter
public class Contribution {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double feeCharges;
    private double monthlyContribution;
    @ManyToOne(fetch =  FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date contributerDate=new Date();

}
