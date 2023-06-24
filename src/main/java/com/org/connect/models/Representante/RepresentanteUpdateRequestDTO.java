package com.org.connect.models.Representante;

import java.time.LocalDate;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class RepresentanteUpdateRequestDTO {
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

    @Size(min = 2, message = "Cargo invalido: debe ser al menos de 2 caracteres")
    private String cargo;

    @Size(min = 2, message = "Rol invalido: debe ser al menos de 2 caracteres")
    private String rol;

    private long organizacion;
}