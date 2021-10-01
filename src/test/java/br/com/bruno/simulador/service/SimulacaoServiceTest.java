package br.com.bruno.simulador.service;


import br.com.bruno.simulador.exception.ErroNaParcelaException;
import br.com.bruno.simulador.model.Simulacao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class SimulacaoServiceTest {


    @Autowired
    private SimulacaoService simulacaoService;

    /*
    * HAPPY PATH
    * */

    @Test
    void calculoParaPagamentoDebito() {
        Simulacao simulacao = new Simulacao(1, BigDecimal.valueOf(200), "DEBITO");
        BigDecimal valorGerado = simulacaoService.geraCalculo(simulacao);
        assertEquals(BigDecimal.valueOf(196.50).setScale(2), valorGerado.setScale(2));
    }

    @Test
    void calculoParaPagamentoCreditoCJurosAVista() {
        Simulacao simulacao = new Simulacao(1, BigDecimal.valueOf(200), "CREDITOCJUROS");
        BigDecimal valorGerado = simulacaoService.geraCalculo(simulacao);
        assertEquals(BigDecimal.valueOf(193.42).setScale(2), valorGerado.setScale(2));
    }

    @Test
    void calculoParaPagamentoCreditoSJurosAVista() {
        Simulacao simulacao = new Simulacao(1, BigDecimal.valueOf(200), "CREDITOSJUROS");
        BigDecimal valorGerado = simulacaoService.geraCalculo(simulacao);
        assertEquals(BigDecimal.valueOf(193.62).setScale(2), valorGerado.setScale(2));
    }

    @Test
    void calculoParaPagamentoCreditoCJurosParcelado() {
        Simulacao simulacao = new Simulacao(3, BigDecimal.valueOf(200), "CREDITOCJUROS");
        BigDecimal valorGerado = simulacaoService.geraCalculo(simulacao);
        assertEquals(BigDecimal.valueOf(175.08).setScale(2), valorGerado.setScale(2));
    }

    @Test
    void calculoParaPagamentoCreditoSJurosParcelado() {
        Simulacao simulacao = new Simulacao(3, BigDecimal.valueOf(200), "CREDITOSJUROS");
        BigDecimal valorGerado = simulacaoService.geraCalculo(simulacao);
        assertEquals(BigDecimal.valueOf(176.88).setScale(2), valorGerado.setScale(2));
    }


}