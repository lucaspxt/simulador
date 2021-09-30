package br.com.bruno.simulador.dto;

import br.com.bruno.simulador.model.Simulacao;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class SimulacaoRequest {

    @Min(value = 1, message = "O número de parcelas não pode ser menor que 1.")
    @Max(value = 12, message = "O número de parcelas não pode ser maior que 12.")
    private int parcelaDaVenda;

    @Positive(message = "O valor não pode ser negativo.")
    private BigDecimal valorSimulado;

    private String formaPagamento;

    @Deprecated
    public SimulacaoRequest() {
    }

    public SimulacaoRequest(int parcelaDaVenda, BigDecimal valorSimulado, String formaPagamento) {
        this.parcelaDaVenda = parcelaDaVenda;
        this.valorSimulado = valorSimulado;
        this.formaPagamento = formaPagamento;
    }

    public SimulacaoRequest(int parcelaDaVenda, BigDecimal valorSimulado) {
        this.parcelaDaVenda = parcelaDaVenda;
        this.valorSimulado = valorSimulado;
    }

    public int getParcelaDaVenda() {
        return parcelaDaVenda;
    }

    public BigDecimal getValorSimulado() {
        return valorSimulado;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public Simulacao toDto() {
        return new Simulacao(parcelaDaVenda, valorSimulado, formaPagamento);
    }
}
