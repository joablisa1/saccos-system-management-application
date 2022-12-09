package com.saccossystemmanagement.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "payment")
@Data
@NoArgsConstructor
@Getter
@Setter
public class Payment {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double amount;

}
