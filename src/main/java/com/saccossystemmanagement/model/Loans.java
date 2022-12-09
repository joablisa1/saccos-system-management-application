package com.saccossystemmanagement.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "loans")
public class Loans {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double principalAmount;
    private double totalMonthlyContribution;
    private double borrowedAmount;

}
