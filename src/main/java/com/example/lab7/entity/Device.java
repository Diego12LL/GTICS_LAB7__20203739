package com.example.lab7.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.text.DecimalFormat;
import java.util.Date;

@Entity
@Table(name = "device")
@Getter
@Setter
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DeviceID",nullable = false)
    private Integer idDevice;

    @Column(name = "DeviceName", length =255)
    private String nombreDevice;

    @Column(name = "DeviceType", length =255)
    private String tipoDevice;

    @Column(name = "Model", length =255)
    private String modeloDevice;

    @Column(name = "SerialNumber", length =255)
    private String serieDevice;

    @ManyToOne
    @JoinColumn (name = "SiteID")
    private Sitio sitio;

}

