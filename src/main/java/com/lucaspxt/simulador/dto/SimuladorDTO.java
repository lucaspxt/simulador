package com.lucaspxt.simulador.dto;

import java.io.Serializable;

import com.lucaspxt.simulador.services.validation.SimuladorVerify;

@SimuladorVerify
public class SimuladorDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Double taxa;
	private Integer parcelas;
	private Double valor;

	public SimuladorDTO() {
		
	}

	public SimuladorDTO(Double taxa, Integer parcelas, Double valor) {
		super();
		this.taxa = taxa;
		this.parcelas = parcelas;
		this.valor = valor;
	}

	public Double getTaxa() {
		return taxa;
	}

	public void setTaxa(Double taxa) {
		this.taxa = taxa;
	}

	public Integer getParcelas() {
		return parcelas;
	}

	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
