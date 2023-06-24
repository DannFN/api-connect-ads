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

import com.org.connect.models.Organizacion.Organizacion;
import com.org.connect.models.Organizacion.OrganizacionRequestDTO;
import com.org.connect.models.Organizacion.OrganizacionUpdateRequestDTO;
import com.org.connect.services.OrganizacionService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class OrganizacionController {
    private final OrganizacionService organizacionService;

    @GetMapping(value = "/organizacion", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<Organizacion> getOrganizaciones() {
        return organizacionService.getOrganizaciones();
    }

    @PostMapping(value = "/organizacion", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Organizacion> createOrganizacion(@Valid @RequestBody OrganizacionRequestDTO organizacion) {
        return new ResponseEntity<>(organizacionService.saveOrganizacion(organizacion), HttpStatus.CREATED);
    }

    @GetMapping(value = "/organizacion/{id}", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Organizacion> getOrganizacion(@PathVariable long id) {
        return organizacionService.getOrganizacion(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping(value = "/organizacion/{id}", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Organizacion> updateOrganizacion(@PathVariable long id,
            @Valid @RequestBody OrganizacionUpdateRequestDTO organizacionUpdateRequest) {
        return new ResponseEntity<>(organizacionService.updateOrganizacion(id, organizacionUpdateRequest), HttpStatus.OK);
    }

    @DeleteMapping(value = "/organizacion/{id}", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOrganizacion(@PathVariable long id) {
        organizacionService.deleteOrganizacion(id);
    }
}
