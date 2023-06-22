package com.org.connect.models.Persona;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonaRequestDTO {
    @NotNull(message = "Nombre invalido: no debe ser nulo")
    @NotBlank(message = "Nombre invalido: no debe estar vacio")
    @Size(min = 3, message = "Nombre invalido: debe ser al menos de 3 caracteres")
    @Pattern(regexp = "^[A-Za-z]*$", message = "Nombre Invalido: debe contener únicamente caracteres alfabeticos ")
    private String nombre;

    @NotNull(message = "Primer apellido invalido: no debe ser nulo")
    @NotBlank(message = "Primer apellido invalido: no debe estar vacio")
    @Size(min = 3, message = "Primer apellido invalido: debe ser al menos de 3 caracteres")
    @Pattern(regexp = "^[A-Za-z]*$", message = "Primer apellido invalido: debe contener únicamente caracteres alfabeticos")
    private String primerApellido;

    @NotNull(message = "Segundo apellido invalido: no debe ser nulo")
    @NotBlank(message = "Segundo apellido invalido: no debe estar vacio")
    @Size(min = 3, message = "Segundo apellido invalido: debe ser al menos de 3 caracteres")
    @Pattern(regexp = "^[A-Za-z]*$", message = "Segundo apellido invalido: debe contener únicamente caracteres alfabeticos")
    private String segundoApellido;

    @NotNull(message = "Correo invalido: no debe ser nulo")
    @NotBlank(message = "Correo invalido: no debe estar vacio")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Corro invalido: la cadena no coincide con el patron de un correo electronico")
    private String email;
    
    @NotNull(message = "Telefono invalido: no debe ser nulo")
    @NotBlank(message = "Telefono invalido: no debe estar vacio")
    @Size(min = 10, max = 10, message = "Telefono invalido: debe ser de 10 caracteres")
    @Pattern(regexp = "^[0-9]*$", message = "Telefono invalido: debe contener únicamente caracteres numericos")
    private String telefono;
    
    @NotNull(message = "Fecha de nacimiento invalida: no debe ser nula")
    @NotBlank(message = "Fecha de nacimiento invalida: no debe estar vacia")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Fecha de nacimiento invalida: la cadena no coincide con el patron de una fecha")
    private LocalDate fechaNacimiento;

    @NotNull(message = "Foto de perfil invalida: no debe ser nula")
    @NotBlank(message = "Foto de perfil invalida: no debe estar vacia")
    private String fotoPerfil;
}
