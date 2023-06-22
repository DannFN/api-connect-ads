package com.org.connect.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.org.connect.models.Persona.PersonaRequestDTO;
import com.org.connect.models.Solicitante.Solicitante;
import com.org.connect.models.Solicitante.SolicitanteUpdateRequestDTO;
import com.org.connect.services.SolicitanteService;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class SolicitanteController {
    private final SolicitanteService solicitanteService;

    @GetMapping(value = "/solicitante", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<Solicitante> getSolicitantes() {
        return solicitanteService.getSolicitantes();
    }

    @PostMapping(value = "/solicitante", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Solicitante> createSolicitante(@Valid @RequestBody PersonaRequestDTO solicitante) {
        return new ResponseEntity<>(solicitanteService.saveSolicitante(solicitante), HttpStatus.CREATED);
    }

    @GetMapping(value = "/solicitante/{id}", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Solicitante> getSolicitante(@PathVariable long id) {
        return solicitanteService.getSolicitante(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping(value = "/solicitante/{id}", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Solicitante> updateSolicitante(@PathVariable long id,
            @Valid @RequestBody SolicitanteUpdateRequestDTO solicitanteUpdateRequest) {
        return new ResponseEntity<>(solicitanteService.updateSolicitante(id, solicitanteUpdateRequest), HttpStatus.OK);
    }

    @DeleteMapping(value = "/solicitante/{id}", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public void deleteSolicitante(@PathVariable long id) {
        solicitanteService.deleteSolicitante(id);
    }
}
