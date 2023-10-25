package com.example.posworks05;

import com.example.posworks05.service.FormateadorTelefono;
import com.example.posworks05.service.ValidadorTelefono;
import com.example.posworks05.model.Persona;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

@SpringBootApplication
public class PosworkS05Application implements CommandLineRunner {

    private final ValidadorTelefono validadorTelefono;
    private final FormateadorTelefono formateadorTelefono;

    @Autowired
    public PosworkS05Application(ValidadorTelefono validadorTelefono, FormateadorTelefono formateadorTelefono) {
        this.validadorTelefono = validadorTelefono;
        this.formateadorTelefono = formateadorTelefono;
    }

    public static void main(String[] args) {
        SpringApplication.run(PosworkS05Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner reader = new Scanner(System.in);

        System.out.println("Introduce el nombre: ");
        String nombre = reader.nextLine();

        System.out.println("Introduce el teléfono: ");
        String telefono = reader.nextLine();

        if (validadorTelefono.isValido(telefono)) {
            telefono = validadorTelefono.limpiaNumero(telefono);
            telefono = formateadorTelefono.formatea(telefono);

            Persona persona = new Persona(nombre, telefono);

            System.out.println(persona);
        } else {
            System.out.println("Por favor, introduce un número válido");
        }
    }
}