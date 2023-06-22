package com.org.connect.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.org.connect.models.OfertaLaboral.OfertaLaboral;
import com.org.connect.models.Solicitante.Solicitante;

import lombok.Data;

@Data
@Entity(name = "competencia")
public class Competencia {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "competencia")
    private String competencia;

    @JsonIgnore
    @ManyToMany(mappedBy = "competencias")
    private List<Solicitante> solicitantes;

    @JsonIgnore
    @ManyToMany(mappedBy = "competencias")
    private List<OfertaLaboral> ofertas;
}
