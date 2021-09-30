package br.com.bruno.simulador.model;

import br.com.bruno.simulador.exception.ErroEnumException;
import br.com.bruno.simulador.exception.ErroNaParcelaException;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class Simulacao {

    @Min(value = 1, message = "O número de parcelas não pode ser menor que 1.")
    @Max(value = 12, message = "O número de parcelas não pode ser maior que 12.")
    private int parcelaDaVenda;

    @Positive(message = "O valor não pode ser negativo.")
    private BigDecimal valorSimulado;

    @Enumerated(EnumType.STRING)
    private FormaPagamento formaPagamento;

    @Deprecated
    public Simulacao() {
    }

    public Simulacao(int parcelaDaVenda,
                     BigDecimal valorSimulado,
                     String formaPagamento) {
        this.parcelaDaVenda = parcelaDaVenda;
        this.valorSimulado = valorSimulado;
        try{
            this.formaPagamento = FormaPagamento.valueOf(formaPagamento);
        }catch (IllegalArgumentException e){
            throw new ErroEnumException("O tipo de pagamento e invalido! Insira um tipo valido, DEBITO, CREDITOCJUROS, CREDITOSJUROS");
        }
    }

    public int getParcelaDaVenda() {
        return parcelaDaVenda;
    }

    public BigDecimal getValorSimulado() {
        return valorSimulado;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public BigDecimal formaPagamento(BigDecimal valorSimulado, int parcelaDeJuros) throws ErroNaParcelaException {
        return formaPagamento.calculoJuros(valorSimulado, parcelaDeJuros);
    }
}
