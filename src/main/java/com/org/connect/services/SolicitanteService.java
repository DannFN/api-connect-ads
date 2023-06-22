package com.org.connect.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.org.connect.models.Persona.PersonaRequestDTO;
import com.org.connect.models.Solicitante.Solicitante;
import com.org.connect.models.Solicitante.SolicitanteUpdateRequestDTO;
import com.org.connect.repositories.AreaRepository;
import com.org.connect.repositories.CompetenciaRepository;
import com.org.connect.repositories.EscuelaRepository;
import com.org.connect.repositories.IdiomaRepository;
import com.org.connect.repositories.SolicitanteRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SolicitanteService {
    private final SolicitanteRepository solicitanteRepository;
    private final AreaRepository areaRepository;
    private final EscuelaRepository escuelaRepository;
    private final IdiomaRepository idiomaRepository;
    private final CompetenciaRepository competenciaRepository;

    public List<Solicitante> getSolicitantes() {
        return solicitanteRepository.findAll();
    }

    public Optional<Solicitante> getSolicitante(String email) {
        return solicitanteRepository.findByEmail(email);
    }

    public Optional<Solicitante> getSolicitante(long id) {
        return solicitanteRepository.findById(id);
    }

    public Solicitante saveSolicitante(PersonaRequestDTO solicitanteRequest) {
        return solicitanteRepository.save(
                Solicitante.builder()
                        .nombre(solicitanteRequest.getNombre())
                        .primerApellido(solicitanteRequest.getPrimerApellido())
                        .segundoApellido(solicitanteRequest.getSegundoApellido())
                        .email(solicitanteRequest.getEmail())
                        .telefono(solicitanteRequest.getTelefono())
                        .fechaNacimiento(solicitanteRequest.getFechaNacimiento())
                        .fotoPerfil(solicitanteRequest.getFotoPerfil())
                        .build());
    }

    public Solicitante updateSolicitante(long id, SolicitanteUpdateRequestDTO solicitanteRequestUpdate) {
        var solicitanteToUpdate = solicitanteRepository.findById(id).get();

        solicitanteToUpdate
                .setNombre(solicitanteRequestUpdate.getNombre() != null ? solicitanteRequestUpdate.getNombre()
                        : solicitanteToUpdate.getNombre());
        solicitanteToUpdate.setPrimerApellido(
                solicitanteRequestUpdate.getPrimerApellido() != null ? solicitanteRequestUpdate.getPrimerApellido()
                        : solicitanteToUpdate.getPrimerApellido());
        solicitanteToUpdate.setSegundoApellido(
                solicitanteRequestUpdate.getSegundoApellido() != null ? solicitanteRequestUpdate.getSegundoApellido()
                        : solicitanteToUpdate.getSegundoApellido());
        solicitanteToUpdate.setEmail(solicitanteRequestUpdate.getEmail() != null ? solicitanteRequestUpdate.getEmail()
                : solicitanteToUpdate.getEmail());
        solicitanteToUpdate
                .setTelefono(solicitanteRequestUpdate.getTelefono() != null ? solicitanteRequestUpdate.getTelefono()
                        : solicitanteToUpdate.getTelefono());
        solicitanteToUpdate.setFechaNacimiento(
                solicitanteRequestUpdate.getFechaNacimiento() != null ? solicitanteRequestUpdate.getFechaNacimiento()
                        : solicitanteToUpdate.getFechaNacimiento());
        solicitanteToUpdate.setFotoPerfil(
                solicitanteRequestUpdate.getFotoPerfil() != null ? solicitanteRequestUpdate.getFotoPerfil()
                        : solicitanteToUpdate.getFotoPerfil());
        solicitanteToUpdate.setDescripcion(
                solicitanteRequestUpdate.getDescripcion() != null ? solicitanteRequestUpdate.getDescripcion()
                        : solicitanteToUpdate.getDescripcion());
        solicitanteToUpdate.setEstadoResidencia(
                solicitanteRequestUpdate.getEstadoResidencia() != null ? solicitanteRequestUpdate.getEstadoResidencia()
                        : solicitanteToUpdate.getEstadoResidencia());

        solicitanteRequestUpdate.getAreasInteres().forEach(area -> {
            solicitanteToUpdate.getAreasInteres().add(areaRepository.findById(area).get());
        });

        solicitanteRequestUpdate.getEscuelas().forEach(escuela -> {
            solicitanteToUpdate.getEscuelas().add(escuelaRepository.findById(escuela).get());
        });

        solicitanteRequestUpdate.getIdiomas().forEach(idioma -> {
            solicitanteToUpdate.getIdiomas().add(idiomaRepository.findById(idioma).get());
        });

        solicitanteRequestUpdate.getCompetencias().forEach(competencia -> {
            solicitanteToUpdate.getCompetencias().add(competenciaRepository.findById(competencia).get());
        });

        return solicitanteRepository.save(solicitanteToUpdate);
    }

    public void deleteSolicitante(Long id) {
        solicitanteRepository.deleteById(id);
    }
}
