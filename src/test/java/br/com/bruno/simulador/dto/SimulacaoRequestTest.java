package br.com.bruno.simulador.dto;

import br.com.bruno.simulador.exception.ErroEnumException;
import br.com.bruno.simulador.model.Simulacao;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SimulacaoRequestTest {

    @Test
    void toDto() {
        SimulacaoRequest request = new SimulacaoRequest(1, BigDecimal.valueOf(200), "DEBITO");
        Simulacao simulacao = request.toDto();
        assertEquals(simulacao.getValorSimulado(), request.getValorSimulado());
        assertEquals(simulacao.getParcelaDaVenda(), request.getParcelaDaVenda());
        assertEquals(simulacao.getFormaPagamento().name(), request.getFormaPagamento());
    }

    @Test
    void erroParaConverterParaDtoFormaPagamento() {
        SimulacaoRequest request = new SimulacaoRequest(1, BigDecimal.valueOf(200), "ss");
        ErroEnumException erro = assertThrows(ErroEnumException.class, () -> request.toDto());
        assertTrue(erro.getMessage().contains("O tipo de pagamento e invalido! Insira um tipo valido, DEBITO, CREDITOCJUROS, CREDITOSJUROS"));
    }

}