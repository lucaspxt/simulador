package com.evolucao.canais.simulator.dto;

import com.evolucao.canais.simulator.model.Parametros;

import javax.validation.constraints.Positive;

public class ParametrosDTO {

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


    public Parametros transformToObject(){

        return new Parametros(valor, taxa, qtdParcelas);

    }

    public ParametrosDTO(float valor, float taxa, int qtdParcelas) {
        this.valor = valor;
        this.taxa = taxa;
        this.qtdParcelas = qtdParcelas;
    }
}
