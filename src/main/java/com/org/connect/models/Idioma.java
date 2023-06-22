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
@Entity(name = "idioma")
public class Idioma {
    @Id
    @GeneratedValue
    private long id;
    
    @Column(name = "idioma")
    private String idioma;

    @JsonIgnore
    @ManyToMany(mappedBy = "idiomas")
    private List<Solicitante> solicitantes;
}
