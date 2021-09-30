package br.com.bruno.simulador.controller;

import br.com.bruno.simulador.dto.SimulacaoRequest;
import br.com.bruno.simulador.service.SimulacaoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SimuladorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SimulacaoService simulacaoService;


    /*
    * HAPPY PATH
    * */

    @Test
    void simulacaoVendaDebitoERetornaStatus200OK() throws Exception {
        SimulacaoRequest request = new SimulacaoRequest(1, BigDecimal.valueOf(200), "DEBITO");
        BigDecimal valorRetorno = BigDecimal.valueOf(196.50);
        mockMvc.perform(get("/api/simulador")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.valorAReceber").value(valorRetorno))
                .andExpect(status().isOk());
    }

    @Test
    void simulacaoVendaParceladaCreditoCJurosERetornaStatus200OK() throws Exception {
        SimulacaoRequest request = new SimulacaoRequest(2, BigDecimal.valueOf(200), "CREDITOCJUROS");
        BigDecimal valorRetorno = BigDecimal.valueOf(181.66);
        mockMvc.perform(get("/api/simulador")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.valorAReceber").value(valorRetorno))
                .andExpect(status().isOk());
    }

    @Test
    void simulacaoVendaAVistaCreditoSJurosERetornaStatus200OK() throws Exception {
        SimulacaoRequest request = new SimulacaoRequest(1, BigDecimal.valueOf(200),"CREDITOSJUROS");
        BigDecimal valorRetorno = BigDecimal.valueOf(193.62);
        mockMvc.perform(get("/api/simulador")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.valorAReceber").value(valorRetorno))
                .andExpect(status().isOk());
    }

    @Test
    void simulacaoVendaAVistaCreditoCJurosERetornaStatus200OK() throws Exception {
        SimulacaoRequest request = new SimulacaoRequest(1, BigDecimal.valueOf(200), "CREDITOCJUROS");
        BigDecimal valorRetorno = BigDecimal.valueOf(193.42);
        mockMvc.perform(get("/api/simulador")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.valorAReceber").value(valorRetorno))
                .andExpect(status().isOk());
    }

    @Test
    void simulacaoVendaParceladaCreditoSJurosERetornaStatus200OK() throws Exception {
        SimulacaoRequest request = new SimulacaoRequest(2, BigDecimal.valueOf(200), "CREDITOSJUROS");
        BigDecimal valorRetorno = BigDecimal.valueOf(183.26);
        mockMvc.perform(get("/api/simulador")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.valorAReceber").value(valorRetorno))
                .andExpect(status().isOk());
    }

    /*
    ERROS
    * */

    @Test
    void erroNaVendaNumeroParcelasIncorretoERetornaStatus400OK() throws Exception {
        SimulacaoRequest request = new SimulacaoRequest(2, BigDecimal.valueOf(200), "DEBITO");
        mockMvc.perform(get("/api/simulador")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.mensagens").value("Compras no débito, não podem ser parceladas"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void erroNaVendaValorSimuladoNegativoERetornaStatus400OK() throws Exception {
        SimulacaoRequest request = new SimulacaoRequest(1, BigDecimal.valueOf(-200), "DEBITO");
        mockMvc.perform(get("/api/simulador")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.mensagens").value("O valor não pode ser negativo."))
                .andExpect(status().isBadRequest());
    }

    @Test
    void erroNaVendaFormaPagamentoInvalidaERetornaStatus400OK() throws Exception {
        SimulacaoRequest request = new SimulacaoRequest(1, BigDecimal.valueOf(200), "");
        mockMvc.perform(get("/api/simulador")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.mensagens").value("O tipo de pagamento e invalido! Insira um tipo valido, DEBITO, CREDITOCJUROS, CREDITOSJUROS"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void erroNaVendaParceladaNumeroParcelasInvalida() throws Exception {
        SimulacaoRequest request = new SimulacaoRequest(22, BigDecimal.valueOf(200), "CREDITOSJUROS");
        mockMvc.perform(get("/api/simulador")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.mensagens").value("O número de parcelas não pode ser maior que 12."))
                .andExpect(status().isBadRequest());
    }
}