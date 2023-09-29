package com.example.lab7.repository;

import com.example.lab7.Dto.DevicePorPaisesDto;
import com.example.lab7.entity.Device;
import com.example.lab7.entity.Locacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Integer> {


    @Query(value = "SELECT l.Country as pais, count(l.Country) as cantidadEquipos FROM device d\n" +
            "inner join site s on d.SiteID = s.SiteID\n" +
            "inner join location l on s.LocationID = l.LocationID\n" +
            "group by l.Country; ",
            nativeQuery = true)
    List<DevicePorPaisesDto> obtenerEstadisticasDevice();
}