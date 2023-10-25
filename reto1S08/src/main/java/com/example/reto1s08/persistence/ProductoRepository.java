package com.example.reto1s08.persistence;

import com.example.reto1s08.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto,Long> {

}
