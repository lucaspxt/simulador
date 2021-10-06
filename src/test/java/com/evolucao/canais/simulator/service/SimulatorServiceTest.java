package com.evolucao.canais.simulator.service;

import com.evolucao.canais.simulator.dto.ParametrosDTO;
import com.evolucao.canais.simulator.model.Parametros;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SimulatorServiceTest {

    @Autowired
    private SimulatorService simulatorService;

    @Test
    void calculandoTaxa(){

        Parametros parametros = new Parametros(1000.00F, 1.5F, 2);
        Float calcular = simulatorService.calcular(parametros);
        assertEquals(970.00F, calcular);

    }


}