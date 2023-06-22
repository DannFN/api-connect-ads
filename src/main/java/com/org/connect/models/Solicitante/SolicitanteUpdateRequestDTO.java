package com.org.connect.models.Solicitante;

import java.time.LocalDate;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class SolicitanteUpdateRequestDTO {
    @Size(min = 3, message = "Nombre invalido: debe ser al menos de 3 caracteres")
    @Pattern(regexp = "^[A-Za-z]*$", message = "Nombre Invalido: debe contener únicamente caracteres alfabeticos ")
    private String nombre;

    @Size(min = 3, message = "Primer apellido invalido: debe ser al menos de 3 caracteres")
    @Pattern(regexp = "^[A-Za-z]*$", message = "Primer apellido invalido: debe contener únicamente caracteres alfabeticos")
    private String primerApellido;

    @Size(min = 3, message = "Segundo apellido invalido: debe ser al menos de 3 caracteres")
    @Pattern(regexp = "^[A-Za-z]*$", message = "Segundo apellido invalido: debe contener únicamente caracteres alfabeticos")
    private String segundoApellido;

    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Corro invalido: la cadena no coincide con el patron de un correo electronico")
    private String email;
    
    @Size(min = 10, max = 10, message = "Telefono invalido: debe ser de 10 caracteres")
    @Pattern(regexp = "^[0-9]*$", message = "Telefono invalido: debe contener únicamente caracteres numericos")
    private String telefono;
    
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Fecha de nacimiento invalida: la cadena no coincide con el patron de una fecha")
    private LocalDate fechaNacimiento;

    private String fotoPerfil;

    private String descripcion;

    @NotNull(message = "Estado invalido: no debe ser nulo")
    @NotBlank(message = "Estado invalido: no debe estar vacio")
    private String estadoResidencia;

    private Set<Long> escuelas;
    private Set<Long> idiomas;
    private Set<Long> competencias;
    private Set<Long> areasInteres;
}
