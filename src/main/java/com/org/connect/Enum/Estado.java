package com.org.connect.Enum;

import lombok.Getter;

@Getter
public enum Estado {
    AGUASCALIENTES("Aguascalientes"),
    BAJA_CALIFORNIA("Baja California"),
    BAJA_CALIFORNIA_SUR("Baja California Sur"),
    CAMPECHE("Campeche"),
    CHIAPAS("Chiapas"),
    CHIHUAHUA("Chihuahua"),
    CIUDAD_DE_MEXICO("Ciudad de México"),
    COAHUILA("Coahuila"),
    COLIMA("Colima"),
    DURANGO("Durango"),
    ESTADO_DE_MEXICO("Estado de México"),
    GUANAJUATO("Guanajuato"),
    GUERRERO("Guerrero"),
    HIDALGO("Hidalgo"),
    JALISCO("Jalisco"),
    MICHOACAN("Michoacán"),
    MORELOS("Morelos"),
    NAYARIT("Nayarit"),
    NUEVO_LEON("Nuevo León"),
    OAXACA("Oaxaca"),
    PUEBLA("Puebla"),
    QUERETARO("Querétaro"),
    QUINTANA_ROO("Quintana Roo"),
    SAN_LUIS_POTOSI("San Luis Potosí"),
    SINALOA("Sinaloa"),
    SONORA("Sonora"),
    TABASCO("Tabasco"),
    TAMAULIPAS("Tamaulipas"),
    TLAXCALA("Tlaxcala"),
    VERACRUZ("Veracruz"),
    YUCATAN("Yucatán"),
    ZACATECAS("Zacatecas");

    private final String estado;

    private Estado(String estado) {
        this.estado = estado;
    }

    public Estado getEstado(String estado) {
        for (Estado e : Estado.values()) {
            if (e.getEstado().equals(estado)) {
                return e;
            }
        }
        return null;
    }
}
