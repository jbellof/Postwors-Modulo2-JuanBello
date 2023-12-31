package com.example.posworks08.controller;

import com.example.posworks08.model.Persona;
import com.example.posworks08.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class AgendaController {

    private final AgendaService agendaService;


    @Autowired
    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @GetMapping({"/", "/index"})
    public String formularioRegistro(Model model) {
        model.addAttribute("persona", new Persona());
        model.addAttribute("listaPersonas", agendaService.getPersonas());

        return "index";
    }

    @PostMapping("/registro")
    public String registra(@Valid Persona persona, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // En caso de errores de validación, maneja los errores y muestra la página de registro con los errores.
            model.addAttribute("listaPersonas", agendaService.getPersonas());
            return "index"; // Devuelve la vista de registro
        }
        agendaService.guardaPersona(persona);

        ModelAndView mav = new ModelAndView("index");
        mav.addObject("listaPersonas", agendaService.getPersonas());
        return "redirect:/index";
    }

}