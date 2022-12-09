package com.saccossystemmanagement.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "address")
@Data
@NoArgsConstructor
@Getter
@Setter
public class Address {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String postalAddress;
    private String postalCode;
    private String town;
    private String village;

}
