package com.evolucao.canais.simulator.controller;

import com.evolucao.canais.simulator.dto.ParametrosDTO;
import com.evolucao.canais.simulator.service.SimulatorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SimulatorControllerTest {

    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    SimulatorService simulatorService;
    @Autowired
    MockMvc mockMvc;

    @Test
    void simulandoRequestComSucesso200Ok() throws Exception {

        ParametrosDTO parametrosDTO = new ParametrosDTO(1000.00F, 1.5F, 2);

    mockMvc.perform(get("/api")
            .contentType("application/json")
            .content(objectMapper.writeValueAsString(parametrosDTO)))
            .andExpect(status().isOk());
    }

    @Test
    void usuarioDigitouValorIncorreto()  throws Exception {

        ParametrosDTO parametrosDTO = new ParametrosDTO (-1000.00F, 1.5F, 2);
        mockMvc.perform(get("/api")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(parametrosDTO)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Valor deve ser positivo."))
                .andExpect(status().isBadRequest());

    }

    @Test
    void usuarioDigitouTaxaIncorreta()  throws Exception {

        ParametrosDTO parametrosDTO = new ParametrosDTO (1000.00F, -1.5F, 2);
        mockMvc.perform(get("/api")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(parametrosDTO)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Taxa deve ser positiva."))
                .andExpect(status().isBadRequest());

    }

    @Test
    void usuarioDigitouParcelasIncorreta()  throws Exception {

        ParametrosDTO parametrosDTO = new ParametrosDTO (1000.00F, 1.5F, -2);
        mockMvc.perform(get("/api")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(parametrosDTO)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Insira a quantidade de parcelas da venda."))
                .andExpect(status().isBadRequest());

    }

    @Test
    void usuarioDigitouAtributoZerado()  throws Exception {

        ParametrosDTO parametrosDTO = new ParametrosDTO (1000.00F, 1.5F, 0);
        mockMvc.perform(get("/api")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(parametrosDTO)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Insira a quantidade de parcelas da venda."))
                .andExpect(status().isBadRequest());

    }

}