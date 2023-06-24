package com.org.connect.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.org.connect.models.Representante.Representante;
import com.org.connect.models.Representante.RepresentanteUpdateRequestDTO;
import com.org.connect.services.RepresentanteService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class RepresentanteController {
    private final RepresentanteService representanteService;

    @GetMapping(value = "/representante", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<Representante> getRepresentantees() {
        return representanteService.getRepresentantes();
    }

    @PostMapping(value = "/representante", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Representante> createRepresentante(@Valid @RequestBody PersonaRequestDTO representante) {
        return new ResponseEntity<>(representanteService.saveRepresentante(representante), HttpStatus.CREATED);
    }

    @GetMapping(value = "/representante/{id}", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Representante> getRepresentante(@PathVariable long id) {
        return representanteService.getRepresentante(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping(value = "/representante/{id}", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Representante> updateRepresentante(@PathVariable long id,
            @Valid @RequestBody RepresentanteUpdateRequestDTO representanteUpdateRequest) {
        return new ResponseEntity<>(representanteService.updateRepresentante(id, representanteUpdateRequest), HttpStatus.OK);
    }

    @DeleteMapping(value = "/representante/{id}", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public void deleteRepresentante(@PathVariable long id) {
        representanteService.deleteRepresentante(id);
    }
}
