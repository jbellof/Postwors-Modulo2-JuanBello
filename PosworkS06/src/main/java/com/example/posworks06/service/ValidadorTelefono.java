package com.example.posworks06.service;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class ValidadorTelefono {

    private static final Pattern PATTERN_TELEFONO = Pattern.compile("^[3-9]\\d{9}$");

    public boolean isValido(String telefono) {
        return PATTERN_TELEFONO.matcher(telefono).matches();
    }

    public String limpiaNumero(String telefono) {
        // Elimina todos los caracteres no numéricos
        String numeroLimpio = telefono.replaceAll("[^0-9]", "");

        // Verifica si el número tiene 10 dígitos (nomenclatura colombiana)
        if (numeroLimpio.length() == 10) {
            // Reformatea el número en la nomenclatura colombiana
            return String.format("(%s)%s-%s-%s",
                    numeroLimpio.substring(0, 3),
                    numeroLimpio.substring(3, 6),
                    numeroLimpio.substring(6, 8),
                    numeroLimpio.substring(8)
            );
        } else {
            // Si el número no tiene 10 dígitos, devuelve el número original
            return telefono;
        }
    }
}
