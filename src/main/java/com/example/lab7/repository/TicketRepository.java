package com.example.lab7.repository;

//import com.example.lab7.dto.SitioMinimoDto;
//import com.example.lab7.dto.SitiosEstadisticaDto;
import com.example.lab7.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {



}

