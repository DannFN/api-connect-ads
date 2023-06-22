package com.org.connect.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.connect.models.Solicitante.Solicitante;

public interface SolicitanteRepository extends JpaRepository<Solicitante, Long>{
    Optional<Solicitante> findByEmail(String email);
}
