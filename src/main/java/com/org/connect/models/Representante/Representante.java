package com.org.connect.models.Representante;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.org.connect.models.Organizacion.Organizacion;
import com.org.connect.models.Persona.Persona;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity(name = "representante")
public class Representante extends Persona {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "rol")
    private String rol;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "organizacion_id")
    private Organizacion organizacion;

    @Builder
    public Representante(String nombre, String primerApellido, String segundoApellido, String email, String telefono,
            LocalDate fechaNacimiento, String fotoPerfil, String cargo, String rol) {
        super(nombre, primerApellido, segundoApellido, email, telefono, fechaNacimiento, fotoPerfil);
        this.cargo = cargo;
        this.rol = rol;
    } 
}
