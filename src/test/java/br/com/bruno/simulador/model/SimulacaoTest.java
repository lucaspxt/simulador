package br.com.bruno.simulador.model;

import br.com.bruno.simulador.exception.ErroEnumException;
import br.com.bruno.simulador.exception.ErroNaParcelaException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SimulacaoTest {

    @Test
    void pagamentoDebito() {
        Simulacao simulacao = new Simulacao(1, BigDecimal.valueOf(200), "DEBITO");
        BigDecimal retorno = simulacao.formaPagamento(simulacao.getValorSimulado(), simulacao.getParcelaDaVenda());
        assertEquals(retorno.setScale(2), BigDecimal.valueOf(196.50).setScale(2));
    }

    @Test
    void pagamentoCreditoCJurosAVista() {
        Simulacao simulacao = new Simulacao(1, BigDecimal.valueOf(200), "CREDITOCJUROS");
        BigDecimal retorno = simulacao.formaPagamento(simulacao.getValorSimulado(), simulacao.getParcelaDaVenda());
        assertEquals(retorno.setScale(2), BigDecimal.valueOf(193.42).setScale(2));
    }

    @Test
    void pagamentoCreditoCJurosParcelado() {
        Simulacao simulacao = new Simulacao(10, BigDecimal.valueOf(200), "CREDITOCJUROS");
        BigDecimal retorno = simulacao.formaPagamento(simulacao.getValorSimulado(), simulacao.getParcelaDaVenda());
        assertEquals(retorno.setScale(2), BigDecimal.valueOf(129.02).setScale(2));
    }

    @Test
    void pagamentoCreditoSJurosAVista() {
        Simulacao simulacao = new Simulacao(1, BigDecimal.valueOf(200), "CREDITOSJUROS");
        BigDecimal retorno = simulacao.formaPagamento(simulacao.getValorSimulado(), simulacao.getParcelaDaVenda());
        assertEquals(retorno.setScale(2), BigDecimal.valueOf(193.62).setScale(2));
    }

    @Test
    void pagamentoCreditoSJurosParcelado() {
        Simulacao simulacao = new Simulacao(10, BigDecimal.valueOf(200), "CREDITOSJUROS");
        BigDecimal retorno = simulacao.formaPagamento(simulacao.getValorSimulado(), simulacao.getParcelaDaVenda());
        assertEquals(retorno.setScale(2), BigDecimal.valueOf(132.22).setScale(2));
    }

    @Test
    void erroAoParcelarComprasNoDebito() {
        Simulacao simulacao = new Simulacao(10, BigDecimal.valueOf(200), "DEBITO");
        ErroNaParcelaException erro = assertThrows(ErroNaParcelaException.class,
                () -> simulacao.formaPagamento(simulacao.getValorSimulado(), simulacao.getParcelaDaVenda()));
        assertTrue(erro.getMessage().contains("Compras no débito, não podem ser parceladas"));
    }

    @Test
    void erroAoParcelarComprasNoDebito1() {
        ErroEnumException erro = assertThrows(ErroEnumException.class,
                () -> new Simulacao(10, BigDecimal.valueOf(200), "DEBITOs"));
        assertTrue(erro.getMessage().contains("O tipo de pagamento e invalido! Insira um tipo valido, DEBITO, CREDITOCJUROS, CREDITOSJUROS"));
    }

}