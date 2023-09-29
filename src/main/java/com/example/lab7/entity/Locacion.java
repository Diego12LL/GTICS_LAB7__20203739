package com.example.lab7.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.text.DecimalFormat;
import java.util.Date;

@Entity
@Table(name = "location")
@Getter
@Setter
public class Locacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LocationID",nullable = false)
    private Integer idlocacion;

    @Column(name = "City", length =255)
    private String nombreciudad;

    @Column(name = "Country", length =255)
    private String nombrepais;

}

