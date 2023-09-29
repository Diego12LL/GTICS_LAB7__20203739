package com.example.lab7.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.*;

import java.text.DecimalFormat;
import java.util.Date;

@Entity
@Table(name = "technician")
@Getter
@Setter
public class Tecnico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TechnicianID",nullable = false)
    private Integer idTecnico;

    @Column(name = "FirstName")
    @NotBlank
    @Size(min=3 , max=100, message = "El nombre NO cumple con el número de caracteres")
    private String nombre;

    @Column(name = "LastName")
    @NotBlank
    @Size(min=3 , max=100, message = "El apellido NO cumple con el número de caracteres")
    private String apellido;

    @Column(name = "Dni")
    @NotBlank
    @Digits(integer = 8, fraction = 0)
    private String dni;

    @Column(name = "Phone")
    @NotBlank
    @Digits(integer = 9, fraction = 0)
    private String celular;

    @Column(name = "Age")

    @Positive
    @Digits(integer = 9, fraction = 0)
    private int edad;


}
