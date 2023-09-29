package com.example.lab7.controller;

import com.example.lab7.entity.Tecnico;
import com.example.lab7.repository.TecnicoRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class TecnicoController {


    final TecnicoRepository tecnicoRepository;


    public TecnicoController(TecnicoRepository tecnicoRepository) {
        this.tecnicoRepository = tecnicoRepository;
    }


    @GetMapping(value = {"/listaTecnicos"})
    public String listarTecnicos(Model model) {
        model.addAttribute("listaTecnicos", tecnicoRepository.findAll());

        return "listaTecnicos";
    }


    @GetMapping("/crearTecnico")
    public String crearTecnico(@ModelAttribute("tecnico") Tecnico tecnico, Model model) {  //Se agrega el atributo, a parte del model

        return "crearTecnico";
    }

    @GetMapping("/editarTecnico")
    public String editarTecnico(@ModelAttribute("tecnico") Tecnico tecnico,
                              Model model, @RequestParam("id") int id) {
        Optional<Tecnico> optional = tecnicoRepository.findById(id);
        if (optional.isPresent()) {
            tecnico = optional.get();
            model.addAttribute("tecnico", tecnico);
            return "crearTecnico";
        } else {
            return "redirect:/listaTecnicos";
        }
    }


    @PostMapping("/guardarTecnico")
    public String guardarTecnico(@ModelAttribute("tecnico") @Valid Tecnico tecnico, BindingResult bindingResult, RedirectAttributes attr, Model model) {

        if(bindingResult.hasErrors()){
            return "crearTecnico";
        }else{
            attr.addFlashAttribute("msg", "Tecnico " + tecnico.getNombre()  + ' ' +  tecnico.getApellido()     + (tecnico.getIdTecnico() == null ? " creado " : " actualizado ") + "exitosamente");
            tecnicoRepository.save(tecnico);
            return "redirect:/listaTecnicos";
        }
    }


    @GetMapping("/borrarTecnico")
    public String borrarSitio(@RequestParam("id") int id, RedirectAttributes attr) {

        Optional<Tecnico> optional = tecnicoRepository.findById(id);

        if (optional.isPresent()) {

            tecnicoRepository.deleteById(id);
            attr.addFlashAttribute("msg", "Técnico borrado correctamente");
        }

        return "redirect:/listaTecnicos";
    }


}