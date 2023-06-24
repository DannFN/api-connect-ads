package com.org.connect.models.OfertaLaboral;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.org.connect.models.Area;
import com.org.connect.models.Competencia;
import com.org.connect.models.Organizacion.Organizacion;
import com.org.connect.models.Solicitante.Solicitante;

import lombok.Builder;
import lombok.Data;

@Data
@Entity(name = "oferta_laboral")
public class OfertaLaboral {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "salario")
    private String salario;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "oferta_competencia", 
            joinColumns = @JoinColumn(name = "oferta_id"), 
            inverseJoinColumns = @JoinColumn(name = "competencia_id"))
    private Set<Competencia> competencias;
    
    @ManyToOne
    @JoinColumn(name = "area_id")
    private Area area;

    @Column(name = "latitud")
    private double latitud;

    @Column(name = "longitud")
    private double longitud;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "organizacion_id")
    private Organizacion organizacion;

    @JsonIgnore
    @ManyToMany(mappedBy = "ofertas")
    private Set<Solicitante> solicitantes;

    @Builder
    public OfertaLaboral(String titulo, String descripcion, String salario, Set<Competencia> competencias, Area area, double latitud, double longitud, Organizacion organizacion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.salario = salario;
        this.area = area;
        this.latitud = latitud;
        this.longitud = longitud;
        this.organizacion = organizacion;
    }
}
