package com.vehiculo.Backend_picoyplaca.service;

import com.vehiculo.Backend_picoyplaca.model.ConsultaRequest;
import com.vehiculo.Backend_picoyplaca.model.ConsultaResponse;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Service
public class PicoYPlacaService {

    public ConsultaResponse validar(ConsultaRequest request) {
        String placa = request.getPlaca();
        String fechaHoraStr = request.getFechaHora();

        // Parsear la fecha ingresada
        LocalDateTime fechaHoraIngresada;
        try {
            fechaHoraIngresada = LocalDateTime.parse(fechaHoraStr, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        } catch (DateTimeParseException e) {
            return new ConsultaResponse(placa, "El formato de fecha y hora es inválido. Debe ser 'yyyy-MM-ddTHH:mm:ss'.");
        }

        // Obtener la fecha y hora actual
        LocalDateTime fechaHoraActual = LocalDateTime.now();

        // Validar que la fecha ingresada no sea anterior a la fecha actual
        if (fechaHoraIngresada.isBefore(fechaHoraActual)) {
            return new ConsultaResponse(placa, "La fecha y hora ingresadas no pueden ser anteriores a la fecha y hora actual.");
        }

        // Continuar con la lógica de validación de Pico y Placa
        int ultimoDigito = obtenerUltimoDigito(placa);
        DayOfWeek diaSemana = fechaHoraIngresada.getDayOfWeek();
        LocalTime hora = fechaHoraIngresada.toLocalTime();

        if (esHoraPico(hora) && aplicaRestriccion(ultimoDigito, diaSemana)) {
            return new ConsultaResponse(placa, "El vehículo NO puede circular en esta fecha y hora.");
        }

        return new ConsultaResponse(placa, "El vehículo puede circular libremente.");
    }

    private int obtenerUltimoDigito(String placa) {
        return Character.getNumericValue(placa.charAt(placa.length() - 1));
    }

    private boolean esHoraPico(LocalTime hora) {
        // Rango matutino: 06:00 - 09:30
        boolean enRangoMatutino = hora.isAfter(LocalTime.of(5, 59)) && hora.isBefore(LocalTime.of(9, 31));
        // Rango vespertino: 16:00 - 21:00
        boolean enRangoVespertino = hora.isAfter(LocalTime.of(15, 59)) && hora.isBefore(LocalTime.of(21, 1));

        return enRangoMatutino || enRangoVespertino;
    }

    private boolean aplicaRestriccion(int ultimoDigito, DayOfWeek diaSemana) {
        return switch (diaSemana) {
            case MONDAY -> ultimoDigito == 1 || ultimoDigito == 2;
            case TUESDAY -> ultimoDigito == 3 || ultimoDigito == 4;
            case WEDNESDAY -> ultimoDigito == 5 || ultimoDigito == 6;
            case THURSDAY -> ultimoDigito == 7 || ultimoDigito == 8;
            case FRIDAY -> ultimoDigito == 9 || ultimoDigito == 0;
            default -> false; // Sábados y domingos no tienen restricción
        };
    }
}
