package com.org.connect.models.Organizacion;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class OrganizacionRequestDTO {
    @NotNull(message = "Razón Social invalida: no debe ser nulo")
    @NotBlank(message = "Razón Social invalida: no debe estar vacio")
    @Size(min = 3, message = "Razón Social invalida: debe ser al menos de 3 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9_.-]*$", message = "Razón Social Invalida: debe contener únicamente caracteres alfanumericos")
    private String razonSocial;

    @NotNull(message = "Email invalido: no debe ser nulo")
    @NotBlank(message = "Email invalido: no debe estar vacio")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Email invalido: la cadena no coincide con el patron de un correo electronico")
    private String email;

    @NotNull(message = "Telefono invalido: no debe ser nulo")
    @NotBlank(message = "Telefono invalido: no debe estar vacio")
    @Pattern(regexp = "^[0-9]*$", message = "Telefono invalido: debe contener únicamente caracteres numericos")
    @Size(min = 10, max = 10, message = "Telefono invalido: debe ser de 10 digitos")
    private String telefono;

    @NotNull(message = "Direccion invalida: no debe ser nulo")
    @NotBlank(message = "Direccion invalida: no debe estar vacio")
    @Size(min = 3, message = "Direccion invalida: debe ser al menos de 3 caracteres")
    private String direccion;

    @NotNull(message = "Foto de perfil invalida: no debe ser nulo")
    @NotBlank(message = "Foto de perfil invalida: no debe estar vacio")
    private String fotoPerfil;

    @NotNull(message = "Descripcion invalida: no debe ser nulo")
    @NotBlank(message = "Descripcion invalida: no debe estar vacio")
    @Size(min = 3, message = "Descripcion invalida: debe ser al menos de 3 caracteres")
    private String descripcion;
}
