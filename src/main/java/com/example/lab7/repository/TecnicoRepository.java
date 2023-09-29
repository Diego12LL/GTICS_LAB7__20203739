package com.example.lab7.repository;

import com.example.lab7.entity.Tecnico;
import com.example.lab7.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {



}
