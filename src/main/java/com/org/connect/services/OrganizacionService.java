package com.org.connect.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.org.connect.models.Organizacion.OrganizacionRequestDTO;
import com.org.connect.models.Organizacion.Organizacion;
import com.org.connect.models.Organizacion.OrganizacionUpdateRequestDTO;
import com.org.connect.repositories.OrganizacionRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrganizacionService {
    private final OrganizacionRepository organizacionRepository;

    public List<Organizacion> getOrganizaciones() {
        return organizacionRepository.findAll();
    }

    public Optional<Organizacion> getOrganizacion(long id) {
        return organizacionRepository.findById(id);
    }

    public Organizacion saveOrganizacion(OrganizacionRequestDTO organizacionRequest) {
        return organizacionRepository.save(
                organizacionRepository.save(
                        Organizacion.builder()
                                .razonSocial(organizacionRequest.getRazonSocial())
                                .email(organizacionRequest.getEmail())
                                .telefono(organizacionRequest.getTelefono())
                                .direccion(organizacionRequest.getDireccion())
                                .fotoPerfil(organizacionRequest.getFotoPerfil())
                                .descripcion(organizacionRequest.getDescripcion())
                                .build()));
    }

    public Organizacion updateOrganizacion(long id, OrganizacionUpdateRequestDTO organizacionRequestUpdate) {
        var organizacionToUpdate = organizacionRepository.findById(id).get();

        organizacionToUpdate.setRazonSocial(
                null != organizacionRequestUpdate.getRazonSocial() ? organizacionRequestUpdate.getRazonSocial()
                        : organizacionToUpdate.getRazonSocial());
        organizacionToUpdate.setEmail(
                null != organizacionRequestUpdate.getEmail() ? organizacionRequestUpdate.getEmail()
                        : organizacionToUpdate.getEmail());
        organizacionToUpdate.setTelefono(
                null != organizacionRequestUpdate.getTelefono() ? organizacionRequestUpdate.getTelefono()
                        : organizacionToUpdate.getTelefono());
        organizacionToUpdate.setDireccion(
                null != organizacionRequestUpdate.getDireccion() ? organizacionRequestUpdate.getDireccion()
                        : organizacionToUpdate.getDireccion());
        organizacionToUpdate.setFotoPerfil(
                null != organizacionRequestUpdate.getFotoPerfil() ? organizacionRequestUpdate.getFotoPerfil()
                        : organizacionToUpdate.getFotoPerfil());
        organizacionToUpdate.setDescripcion(
                null != organizacionRequestUpdate.getDescripcion() ? organizacionRequestUpdate.getDescripcion()
                        : organizacionToUpdate.getDescripcion());

        return organizacionRepository.save(organizacionToUpdate);
    }

    public void deleteOrganizacion(Long id) {
        organizacionRepository.deleteById(id);
    }
}
