package com.org.connect.models.Organizacion;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class OrganizacionUpdateRequestDTO {
    @Size(min = 3, message = "Razón Social invalida: debe ser al menos de 3 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9_.-]*$", message = "Razón Social Invalida: debe contener únicamente caracteres alfanumericos")
    private String razonSocial;

    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Email invalido: la cadena no coincide con el patron de un correo electronico")
    private String email;

    @Pattern(regexp = "^[0-9]*$", message = "Telefono invalido: debe contener únicamente caracteres numericos")
    @Size(min = 10, max = 10, message = "Telefono invalido: debe ser de 10 digitos")
    private String telefono;

    @Size(min = 3, message = "Direccion invalida: debe ser al menos de 3 caracteres")
    private String direccion;

    private String fotoPerfil;

    @Size(min = 3, message = "Descripcion invalida: debe ser al menos de 3 caracteres")
    private String descripcion;
}
