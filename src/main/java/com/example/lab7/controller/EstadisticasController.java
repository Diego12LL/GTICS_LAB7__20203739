package com.example.lab7.controller;

import com.example.lab7.entity.Sitio;
import com.example.lab7.repository.DeviceRepository;
import com.example.lab7.repository.LocacionRepository;
import com.example.lab7.repository.SitioRepository;
import com.example.lab7.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class EstadisticasController {
    @Autowired
    DeviceRepository deviceRepository;
    @GetMapping(value = {"/estadisticas"})
    public String estadisticaDevice(Model model) {


        model.addAttribute("listaEstadisticas", deviceRepository.obtenerEstadisticasDevice());


        return "estadisticasDevice";
    }

}


