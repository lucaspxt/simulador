package com.evolucao.canais.simulator.model;


import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@NoArgsConstructor
public class Parametros {

    @Positive(message = "Valor deve ser positivo.")
    float valor;
    @Positive(message = "Taxa deve ser positiva.")
    float taxa;
    @Positive(message = "Insira a quantidade de parcelas da venda.")
    int qtdParcelas;

    public float getValor() {
        return valor;
    }

    public float getTaxa() {
        return taxa;
    }

    public int getQtdParcelas() {
        return qtdParcelas;
    }


    public Parametros(float valor, float taxa, int qtdParcelas) {
        this.valor = valor;
        this.taxa = taxa;
        this.qtdParcelas = qtdParcelas;
    }

}
