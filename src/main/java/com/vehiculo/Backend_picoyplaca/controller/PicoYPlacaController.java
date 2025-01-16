package com.vehiculo.Backend_picoyplaca.controller;

import com.vehiculo.Backend_picoyplaca.model.ConsultaRequest;
import com.vehiculo.Backend_picoyplaca.model.ConsultaResponse;
import com.vehiculo.Backend_picoyplaca.service.PicoYPlacaService;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
@Validated
@CrossOrigin(origins = {"http://localhost:4200"}) // Permitir solicitudes desde Angular
public class PicoYPlacaController {

    private final PicoYPlacaService picoYPlacaService;

    public PicoYPlacaController(PicoYPlacaService picoYPlacaService) {
        this.picoYPlacaService = picoYPlacaService;
    }

    @PostMapping("/validacion")
    public ResponseEntity<?> validarPlaca(@Valid @RequestBody ConsultaRequest request) {
        ConsultaResponse response = picoYPlacaService.validar(request);
        return ResponseEntity.ok(response);
    }
}
