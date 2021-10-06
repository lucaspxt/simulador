package com.evolucao.canais.simulator.controller;

import com.evolucao.canais.simulator.dto.ParametrosDTO;
import com.evolucao.canais.simulator.model.Parametros;
import com.evolucao.canais.simulator.service.SimulatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class SimulatorController {

    @Autowired
    private SimulatorService simulatorService;

    @GetMapping
    public ResponseEntity<?> simular(@Valid @RequestBody ParametrosDTO dto){

        return ResponseEntity.ok(simulatorService.calcular(dto.transformToObject()));
    }


}
