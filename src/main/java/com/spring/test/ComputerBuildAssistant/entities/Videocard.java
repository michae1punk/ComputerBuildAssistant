package com.spring.test.ComputerBuildAssistant.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class Videocard {
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
    private String GPU;

    @Column
    private Integer videoMemorySize;

    @Column
    private String memoryType;
}
