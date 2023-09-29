package com.example.lab7.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.*;

import java.text.DecimalFormat;
import java.util.Date;

@Entity
@Table(name = "site")
@Getter
@Setter
public class Sitio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SiteID",nullable = false)
    private Integer idsitio;

    @Column(name = "SiteName")
    @NotBlank
    @Size(max=20, message = "El nombre NO puede tener m'as de 20 caracteres")
    private String nombresitio;
    @ManyToOne
    @JoinColumn(name = "LocationID")
    private Locacion locacion;

    @Column(name = "InstallationDate")
    private String fechainstalacion;

    @Column(name = "Latitude")
    private String latitud;

    @Column(name = "Longitude")
    private String longitud;


}
