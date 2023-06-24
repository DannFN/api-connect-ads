package com.org.connect.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.org.connect.models.Persona.PersonaRequestDTO;
import com.org.connect.models.Representante.Representante;
import com.org.connect.models.Representante.RepresentanteUpdateRequestDTO;
import com.org.connect.repositories.OrganizacionRepository;
import com.org.connect.repositories.RepresentanteRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RepresentanteService {
    private final RepresentanteRepository representanteRepository;
    private final OrganizacionRepository organizacionRepository;

    public List<Representante> getRepresentantes() {
        return representanteRepository.findAll();
    }

    public Optional<Representante> getRepresentante(long id) {
        return representanteRepository.findById(id);
    }

    public Representante saveRepresentante(PersonaRequestDTO representanteRequest) {
        return representanteRepository.save(
                Representante.builder()
                        .nombre(representanteRequest.getNombre())
                        .primerApellido(representanteRequest.getPrimerApellido())
                        .segundoApellido(representanteRequest.getSegundoApellido())
                        .email(representanteRequest.getEmail())
                        .telefono(representanteRequest.getTelefono())
                        .fechaNacimiento(representanteRequest.getFechaNacimiento())
                        .fotoPerfil(representanteRequest.getFotoPerfil())
                        .build());
    }

    public Representante updateRepresentante(long id, RepresentanteUpdateRequestDTO representanteRequestUpdate) {
        var representanteToUpdate = representanteRepository.findById(id).get();

        representanteToUpdate
                .setNombre(representanteRequestUpdate.getNombre() != null ? representanteRequestUpdate.getNombre()
                        : representanteToUpdate.getNombre());
        representanteToUpdate.setPrimerApellido(
                representanteRequestUpdate.getPrimerApellido() != null ? representanteRequestUpdate.getPrimerApellido()
                        : representanteToUpdate.getPrimerApellido());
        representanteToUpdate.setSegundoApellido(
                representanteRequestUpdate.getSegundoApellido() != null ? representanteRequestUpdate.getSegundoApellido()
                        : representanteToUpdate.getSegundoApellido());
        representanteToUpdate.setEmail(representanteRequestUpdate.getEmail() != null ? representanteRequestUpdate.getEmail()
                : representanteToUpdate.getEmail());
        representanteToUpdate
                .setTelefono(representanteRequestUpdate.getTelefono() != null ? representanteRequestUpdate.getTelefono()
                        : representanteToUpdate.getTelefono());
        representanteToUpdate.setFechaNacimiento(
                representanteRequestUpdate.getFechaNacimiento() != null ? representanteRequestUpdate.getFechaNacimiento()
                        : representanteToUpdate.getFechaNacimiento());
        representanteToUpdate.setFotoPerfil(
                representanteRequestUpdate.getFotoPerfil() != null ? representanteRequestUpdate.getFotoPerfil()
                        : representanteToUpdate.getFotoPerfil());
        representanteToUpdate.setCargo(null != representanteRequestUpdate.getCargo() ? representanteRequestUpdate.getCargo()
                : representanteToUpdate.getCargo());
        representanteToUpdate.setRol(null != representanteRequestUpdate.getRol() ? representanteRequestUpdate.getRol()
                : representanteToUpdate.getRol());
        
        representanteToUpdate.setOrganizacion(organizacionRepository.findById(representanteRequestUpdate.getOrganizacion()).get());

        return representanteRepository.save(representanteToUpdate);
    }

    public void deleteRepresentante(Long id) {
        representanteRepository.deleteById(id);
    }
}
