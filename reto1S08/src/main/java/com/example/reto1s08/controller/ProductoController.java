package com.example.reto1s08.controller;

import com.example.reto1s08.model.Producto;
import com.example.reto1s08.persistence.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @PostMapping
    public ResponseEntity<Void> creaProducto(@RequestBody Producto producto) {

        Producto productoDB = productoRepository.save(producto);

        return ResponseEntity.created(URI.create(String.valueOf(producto.getId()))).build();
    }

    @GetMapping("/{productoId}")
    public ResponseEntity<Producto> getProducto(@PathVariable Long productoId) {

        Optional<Producto> productoDB = productoRepository.findById(productoId);

        if (!productoDB.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El producto especificado no existe.");

        return ResponseEntity.ok(productoDB.get());
    }
}