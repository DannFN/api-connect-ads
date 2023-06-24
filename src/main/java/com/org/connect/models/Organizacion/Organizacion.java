package com.org.connect.models.Organizacion;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.org.connect.models.OfertaLaboral.OfertaLaboral;
import com.org.connect.models.Representante.Representante;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity(name = "organizacion")
public class Organizacion {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "razon_social")
    private String razonSocial;

    @Column(name = "email")
    private String email;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "foto_perfil")
    private String fotoPerfil;

    @Column(name = "descripcion")
    private String descripcion;

    @JsonIgnore
    @OneToMany(mappedBy = "organizacion")
    private List<OfertaLaboral> ofertas;

    @JsonIgnore
    @OneToMany(mappedBy = "organizacion")
    private List<Representante> representantes;
}
