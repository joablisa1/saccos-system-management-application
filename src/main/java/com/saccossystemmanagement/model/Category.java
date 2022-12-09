package com.saccossystemmanagement.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Category {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;


}
