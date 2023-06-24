package com.org.connect.models.Representante;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class RepresentanteRequestDTO {
    @NotNull(message = "Nombre invalido: no puede ser nulo")
    @NotBlank(message = "Nombre invalido: no puede estar en blanco")
    @Size(min = 3, message = "Nombre invalido: debe ser al menos de 3 caracteres")
    @Pattern(regexp = "^[A-Za-z]*$", message = "Nombre Invalido: debe contener únicamente caracteres alfabeticos ")
    private String nombre;

    @NotNull(message = "Primer apellido invalido: no puede ser nulo")
    @NotBlank(message = "Primer apellido invalido: no puede estar en blanco")
    @Size(min = 3, message = "Primer apellido invalido: debe ser al menos de 3 caracteres")
    @Pattern(regexp = "^[A-Za-z]*$", message = "Primer apellido invalido: debe contener únicamente caracteres alfabeticos")
    private String primerApellido;

    @NotNull(message = "Segundo apellido invalido: no puede ser nulo")
    @NotBlank(message = "Segundo apellido invalido: no puede estar en blanco")
    @Size(min = 3, message = "Segundo apellido invalido: debe ser al menos de 3 caracteres")
    @Pattern(regexp = "^[A-Za-z]*$", message = "Segundo apellido invalido: debe contener únicamente caracteres alfabeticos")
    private String segundoApellido;

    @NotNull(message = "Correo invalido: no puede ser nulo")
    @NotBlank(message = "Correo invalido: no puede estar en blanco")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Corro invalido: la cadena no coincide con el patron de un correo electronico")
    private String email;
    
    @NotNull(message = "Telefono invalido: no puede ser nulo")
    @NotBlank(message = "Telefono invalido: no puede estar en blanco")
    @Size(min = 10, max = 10, message = "Telefono invalido: debe ser de 10 caracteres")
    @Pattern(regexp = "^[0-9]*$", message = "Telefono invalido: debe contener únicamente caracteres numericos")
    private String telefono;
    
    @NotNull(message = "Fecha de nacimiento invalida: no puede ser nulo")
    @NotBlank(message = "Fecha de nacimiento invalida: no puede estar en blanco")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Fecha de nacimiento invalida: la cadena no coincide con el patron de una fecha")
    private LocalDate fechaNacimiento;

    @NotNull(message = "Foto de perfil invalida: no puede ser nulo")
    @NotBlank(message = "Foto de perfil invalida: no puede estar en blanco")
    private String fotoPerfil;

    @NotNull(message = "Cedula invalida: no puede ser nulo")
    @NotBlank(message = "Cedula invalida: no puede estar en blanco")
    @Size(min = 2, message = "Cargo invalido: debe ser al menos de 2 caracteres")
    private String cargo;

    @NotNull(message = "Rol invalido: no puede ser nulo")
    @NotBlank(message = "Rol invalido: no puede estar en blanco")
    @Size(min = 2, message = "Rol invalido: debe ser al menos de 2 caracteres")
    private String rol;

    @NotNull(message = "Organizacion invalida: no puede ser nulo")
    @NotBlank(message = "Organizacion invalida: no puede estar en blanco")
    private long organizacion;
}
