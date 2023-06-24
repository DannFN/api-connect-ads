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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.org.connect.models.OfertaLaboral.OfertaLaboralRequestDTO;
import com.org.connect.models.Solicitante.Solicitante;
import com.org.connect.models.OfertaLaboral.OfertaLaboral;
import com.org.connect.services.OfertaLaboralService;
import com.org.connect.services.SolicitanteService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class OfertaLaboralController {
    private final OfertaLaboralService ofertaLaboralService;
    private final SolicitanteService solicitanteService;

    @GetMapping(value = "/ofertaLaboral", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<OfertaLaboral> getOfertasLaborales() {
        return ofertaLaboralService.getOfertaLaborals();
    }

    @PostMapping(value = "/ofertaLaboral", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<OfertaLaboral> createOfertaLaboral(@Valid @RequestBody OfertaLaboralRequestDTO ofertaLaboral) {
        return new ResponseEntity<>(ofertaLaboralService.saveOfertaLaboral(ofertaLaboral), HttpStatus.CREATED);
    }

    @GetMapping(value = "/ofertaLaboral/{id}", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<OfertaLaboral> getOfertaLaboral(@PathVariable long id) {
        return ofertaLaboralService.getOfertaLaboral(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(value = "/ofertaLaboral/{id}/solicitar", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Solicitante> solicitarOferta(@PathVariable long oferta, @RequestParam long solicitante) {
        return new ResponseEntity<>(solicitanteService.solicitarOferta(solicitante, oferta), HttpStatus.OK);
    }

    @PutMapping(value = "/ofertaLaboral/{id}", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<OfertaLaboral> updateOfertaLaboral(@PathVariable long id,
            @Valid @RequestBody OfertaLaboralRequestDTO ofertaLaboralUpdateRequest) {
        return new ResponseEntity<>(ofertaLaboralService.updateOfertaLaboral(id, ofertaLaboralUpdateRequest), HttpStatus.OK);
    }

    @DeleteMapping(value = "/ofertaLaboral/{id}", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOfertaLaboral(@PathVariable long id) {
        ofertaLaboralService.deleteOfertaLaboral(id);
    }
}
