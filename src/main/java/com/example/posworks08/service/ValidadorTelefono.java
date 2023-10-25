package com.example.posworks08.service;


import org.springframework.stereotype.Service;



@Service
public class ValidadorTelefono {
    public String limpiaNumero(String telefono) {
        return telefono.replaceAll("[^0-9]", "");
    }
}