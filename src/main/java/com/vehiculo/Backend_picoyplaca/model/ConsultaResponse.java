package com.vehiculo.Backend_picoyplaca.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ConsultaResponse {
    private String placa;
    private String mensaje;
}