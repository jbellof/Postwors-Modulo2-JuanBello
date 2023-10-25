package com.example.posworks07.controller;

import com.example.posworks07.model.Persona;
import com.example.posworks07.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

        // Obtén la lista de personas y ordénala por nombre
        Set<Persona> listaPersonas = agendaService.getPersonas();
        List<Persona> listaPersonasOrdenada = listaPersonas.stream()
                .sorted(Comparator.comparing(Persona::getNombre))
                .collect(Collectors.toList());

        model.addAttribute("listaPersonas", listaPersonasOrdenada);

        return "index";
    }


    @PostMapping("/registro")
    public String registra(@Valid Persona persona, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // En caso de errores de validación, maneja los errores y muestra la página de registro con los errores.
            model.addAttribute("listaPersonas", agendaService.getPersonas());
            return "index"; // Devuelve la vista de registro
        }

        // Si no hay errores de validación, guarda la persona y realiza cualquier otra acción necesaria.
        agendaService.guardaPersona(persona);

        // Redirige a la página de inicio.
        return "redirect:/index";
    }
}
