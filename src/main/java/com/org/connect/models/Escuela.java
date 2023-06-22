package com.org.connect.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.org.connect.models.Solicitante.Solicitante;

import lombok.Data;

@Data
@Entity(name = "escuela")
public class Escuela {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "escuela")
    private String escuela;

    @JsonIgnore
    @ManyToMany(mappedBy = "escuelas")
    private List<Solicitante> solicitantes;
}
