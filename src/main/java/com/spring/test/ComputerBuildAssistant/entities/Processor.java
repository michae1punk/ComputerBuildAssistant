package com.spring.test.ComputerBuildAssistant.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class Processor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Double price;

    @Column
    private String companyName;

    @Column
    private String socket;

    @Column
    private Integer cores;

    @Column
    private Double frequency;
}
