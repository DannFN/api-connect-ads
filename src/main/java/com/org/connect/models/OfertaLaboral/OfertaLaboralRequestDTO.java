package com.org.connect.models.OfertaLaboral;

import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class OfertaLaboralRequestDTO {
    @NotNull(message = "Titulo invalido: no debe ser nulo")
    @NotBlank(message = "Titulo invalido: no debe estar vacio")
    @Size(min = 3, message = "Titulo invalido: debe ser al menos de 3 caracteres")
    private String titulo;

    @NotNull(message = "Descripcion invalida: no debe ser nulo")
    @NotBlank(message = "Descripcion invalida: no debe estar vacio")
    private String descripcion;

    @NotNull(message = "Salario invalido: no debe ser nulo")
    @NotBlank(message = "Salario invalido: no debe estar vacio")
    @Pattern(regexp = "^[0-9]+(\\.[0-9]+)?$", message = "Salario invalido: debe ser un numero")
    private String salario;

    private Set<Long> competencias;
    
    @NotNull(message = "Area invalida: no debe ser nulo")
    @NotBlank(message = "Area invalida: no debe estar vacio")
    private long area;

    @NotNull(message = "Tipo de contrato invalido: no debe ser nulo")
    @NotBlank(message = "Tipo de contrato invalido: no debe estar vacio")
    private double latitud;

    @NotNull(message = "Tipo de contrato invalido: no debe ser nulo")
    @NotBlank(message = "Tipo de contrato invalido: no debe estar vacio")
    private double longitud;

    @NotNull(message = "Tipo de contrato invalido: no debe ser nulo")
    @NotBlank(message = "Tipo de contrato invalido: no debe estar vacio")
    private long organizacion;    
}
