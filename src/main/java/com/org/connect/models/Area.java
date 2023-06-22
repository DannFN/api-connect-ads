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
@Entity(name = "area")
public class Area {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "area")
    private String area;

    @JsonIgnore
    @ManyToMany(mappedBy = "areasInteres")
    private List<Solicitante> solicitantes;
}
