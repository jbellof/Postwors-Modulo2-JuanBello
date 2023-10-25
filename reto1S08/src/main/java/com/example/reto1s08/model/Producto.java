package com.example.reto1s08.model;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "PRODUCTO")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "categoria", length = 50)
    private String categoria;

    @Column(name = "precio")
    private float precio;

    @Column(name = "numero_registro", length = 20)
    private String numeroRegistro;

    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;

    public Producto() {
    }

    public Producto(String nombre, String categoria, float precio, String numeroRegistro, LocalDate fechaCreacion) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.numeroRegistro = numeroRegistro;
        this.fechaCreacion = fechaCreacion;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(String numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
