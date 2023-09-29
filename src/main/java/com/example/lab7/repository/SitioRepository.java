package com.example.lab7.repository;

import com.example.lab7.entity.Sitio;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SitioRepository extends JpaRepository<Sitio, Integer> {
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE site SET SiteName = ?1 , LocationID= ?2 , InstallationDate=?3 , Latitude=?4 , Longitude=?5 WHERE SiteID = ?6")
    void actualizarSitio(String nombre, int idLocacion, String fechaDeInstalacion, String latitud, String longitud, int idSitio);


}
