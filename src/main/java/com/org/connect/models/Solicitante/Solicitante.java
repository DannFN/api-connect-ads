package com.org.connect.models.Solicitante;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.org.connect.models.Area;
import com.org.connect.models.Competencia;
import com.org.connect.models.Escuela;
import com.org.connect.models.Idioma;
import com.org.connect.models.OfertaLaboral.OfertaLaboral;
import com.org.connect.models.Persona.Persona;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity(name = "solicitante")
public class Solicitante extends Persona { 
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "estado_residencia")
    private String estadoResidencia;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "solicitante_escuela", 
            joinColumns = @JoinColumn(name = "solicitante_id"), 
            inverseJoinColumns = @JoinColumn(name = "escuela_id"))
    private Set<Escuela> escuelas;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "solicitante_idioma", 
            joinColumns = @JoinColumn(name = "solicitante_id"), 
            inverseJoinColumns = @JoinColumn(name = "idioma_id"))
    private Set<Idioma> idiomas;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "solicitante_competencia", 
            joinColumns = @JoinColumn(name = "solicitante_id"), 
            inverseJoinColumns = @JoinColumn(name = "competencia_id"))
    private Set<Competencia> competencias;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "solicitante_area", 
            joinColumns = @JoinColumn(name = "solicitante_id"), 
            inverseJoinColumns = @JoinColumn(name = "area_id"))
    @Column(name = "area")
    private Set<Area> areasInteres;

    @Transient
    private double latitud;
    @Transient
    private double longitud;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "solicitante_oferta", 
            joinColumns = @JoinColumn(name = "solicitante_id"), 
            inverseJoinColumns = @JoinColumn(name = "oferta_id"))
    private Set<OfertaLaboral> ofertas;

    @Builder
    public Solicitante(String nombre, String primerApellido, String segundoApellido, String email, String telefono,
            LocalDate fechaNacimiento, String fotoPerfil, String descripcion, String estadoResidencia,
            Set<Escuela> escuelas, Set<Idioma> idiomas, Set<Competencia> competencias, Set<Area> areasInteres) {
        super(nombre, primerApellido, segundoApellido, email, telefono, fechaNacimiento, fotoPerfil);
        this.descripcion = descripcion;
        this.estadoResidencia = estadoResidencia;
        this.escuelas = escuelas;
        this.idiomas = idiomas;
        this.competencias = competencias;
        this.areasInteres = areasInteres;
        this.latitud = 0d;
        this.longitud = 0d;
    }   

    public void addEscuela(Escuela escuela) {
        this.escuelas.add(escuela);
        escuela.getSolicitantes().add(this);
    }

    public void removeEscuela(Escuela escuela) {
        this.escuelas.remove(escuela);
        escuela.getSolicitantes().remove(this);
    }

    public void addIdioma(Idioma idioma) {
        this.idiomas.add(idioma);
        idioma.getSolicitantes().add(this);
    }

    public void removeIdioma(Idioma idioma) {
        this.idiomas.remove(idioma);
        idioma.getSolicitantes().remove(this);
    }

    public void addCompetencia(Competencia competencia) {
        this.competencias.add(competencia);
        competencia.getSolicitantes().add(this);
    }

    public void removeCompetencia(Competencia competencia) {
        this.competencias.remove(competencia);
        competencia.getSolicitantes().remove(this);
    }

    public void addArea(Area area) {
        this.areasInteres.add(area);
        area.getSolicitantes().add(this);
    }

    public void removeArea(Area area) {
        this.areasInteres.remove(area);
        area.getSolicitantes().remove(this);
    }
}
