package br.com.bruno.simulador.dto;

import java.math.BigDecimal;

public class SimulacaoResponse {


    private BigDecimal valorAReceber;

    public SimulacaoResponse(BigDecimal calculoGerado) {
        this.valorAReceber = calculoGerado.setScale(2);
    }

    public BigDecimal getValorAReceber() {
        return valorAReceber;
    }

}
