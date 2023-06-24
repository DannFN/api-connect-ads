package com.org.connect.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.org.connect.models.OfertaLaboral.OfertaLaboral;
import com.org.connect.models.OfertaLaboral.OfertaLaboralRequestDTO;
import com.org.connect.repositories.OrganizacionRepository;
import com.org.connect.repositories.AreaRepository;
import com.org.connect.repositories.CompetenciaRepository;
import com.org.connect.repositories.OfertaLaboralRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OfertaLaboralService {
    private final OfertaLaboralRepository ofertaLaboralRepository;
    private final OrganizacionRepository organizacionRepository;
    private final CompetenciaRepository competenciaRepository;
    private final AreaRepository areaRepository;

    public List<OfertaLaboral> getOfertaLaborals() {
        return ofertaLaboralRepository.findAll();
    }

    public Optional<OfertaLaboral> getOfertaLaboral(long id) {
        return ofertaLaboralRepository.findById(id);
    }

    public OfertaLaboral saveOfertaLaboral(OfertaLaboralRequestDTO ofertaLaboralRequest) {
        return ofertaLaboralRepository.save(OfertaLaboral.builder()
                .titulo(ofertaLaboralRequest.getTitulo())
                .descripcion(ofertaLaboralRequest.getDescripcion())
                .salario(ofertaLaboralRequest.getSalario())
                .competencias(ofertaLaboralRequest.getCompetencias().stream()
                        .map(competenciaId -> competenciaRepository.findById(competenciaId)
                                .get())
                        .collect(Collectors.toSet()))
                .area(areaRepository.findById(ofertaLaboralRequest.getArea()).get())
                .latitud(ofertaLaboralRequest.getLatitud())
                .longitud(ofertaLaboralRequest.getLongitud())
                .organizacion(organizacionRepository.findById(ofertaLaboralRequest.getOrganizacion())
                        .get())
                .build());
    }

    public OfertaLaboral updateOfertaLaboral(long id, OfertaLaboralRequestDTO ofertaLaboralRequestUpdate) {
        var ofertaLaboralToUpdate = ofertaLaboralRepository.findById(id).get();

        ofertaLaboralToUpdate.setTitulo(
                null != ofertaLaboralRequestUpdate.getTitulo() ? ofertaLaboralRequestUpdate.getTitulo()
                        : ofertaLaboralToUpdate.getTitulo());
        ofertaLaboralToUpdate.setDescripcion(
                null != ofertaLaboralRequestUpdate.getDescripcion() ? ofertaLaboralRequestUpdate.getDescripcion()
                        : ofertaLaboralToUpdate.getDescripcion());
        ofertaLaboralToUpdate.setSalario(
                null != ofertaLaboralRequestUpdate.getSalario() ? ofertaLaboralRequestUpdate.getSalario()
                        : ofertaLaboralToUpdate.getSalario());

        ofertaLaboralRequestUpdate.getCompetencias().forEach(competenciaId -> {
            ofertaLaboralToUpdate.getCompetencias().add(competenciaRepository.findById(competenciaId).get());
        });

        ofertaLaboralToUpdate.setArea(areaRepository.findById(ofertaLaboralRequestUpdate.getArea())
                .get());
        ofertaLaboralToUpdate.setLatitud(
                0 != ofertaLaboralRequestUpdate.getLatitud() ? ofertaLaboralRequestUpdate.getLatitud()
                        : ofertaLaboralToUpdate.getLatitud());
        ofertaLaboralToUpdate.setLongitud(
                0 != ofertaLaboralRequestUpdate.getLongitud() ? ofertaLaboralRequestUpdate.getLongitud()
                        : ofertaLaboralToUpdate.getLongitud());
        ofertaLaboralToUpdate
                .setOrganizacion(organizacionRepository.findById(ofertaLaboralRequestUpdate.getOrganizacion())
                        .get());

        return ofertaLaboralRepository.save(ofertaLaboralToUpdate);
    }

    public void deleteOfertaLaboral(Long id) {
        ofertaLaboralRepository.deleteById(id);
    }
}
