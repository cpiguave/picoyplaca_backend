package com.vehiculo.Backend_picoyplaca.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class ConsultaRequest {

    @NotBlank(message = "La placa no puede estar vacía.")
    @Pattern(
            regexp = "^[A-Z]{3}-\\d{3,4}$",
            message = "La placa debe tener el formato ABC-123 o ABC-1234."
    )
    private String placa;

    @NotBlank(message = "La fecha y hora no pueden estar vacías.")
    private String fechaHora;

    // Getters y Setters
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }
}
