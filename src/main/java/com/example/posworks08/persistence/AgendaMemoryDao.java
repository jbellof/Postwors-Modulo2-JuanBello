package com.example.posworks08.persistence;


import com.example.posworks08.model.Persona;


import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaMemoryDao extends JpaRepository<Persona, Long> {
}