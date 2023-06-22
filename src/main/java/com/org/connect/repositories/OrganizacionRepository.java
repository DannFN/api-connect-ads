package com.org.connect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.connect.models.Organizacion.Organizacion;

public interface OrganizacionRepository extends JpaRepository<Organizacion, Long>{
}
