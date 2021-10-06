package com.evolucao.canais.simulator.dto;

import com.evolucao.canais.simulator.model.Parametros;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

class ParametrosDTOTest {

    @Test
    void transformandoDTOEmObjeto(){

        ParametrosDTO parametrosDTO = new ParametrosDTO(1000.00F, 1.5F, 2);
        Parametros parametros = parametrosDTO.transformToObject();
        assertEquals(1000.00F, parametros.getValor());
        assertEquals(1.5F, parametros.getTaxa());
        assertEquals(2, parametros.getQtdParcelas());

    }
}