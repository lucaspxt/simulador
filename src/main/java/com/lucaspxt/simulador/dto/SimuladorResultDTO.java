package com.lucaspxt.simulador.dto;

import java.io.Serializable;

public class SimuladorResultDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Double resultado;
	private SimuladorDTO entrada;
	
	public SimuladorResultDTO(Double resultado, SimuladorDTO entrada) {
		super();
		this.resultado = resultado;
		this.entrada = entrada;
	}
	
	public Double getResultado() {
		return resultado;
	}
	public void setResultado(Double resultado) {
		this.resultado = resultado;
	}
	public SimuladorDTO getEntrada() {
		return entrada;
	}
	public void setEntrada(SimuladorDTO entrada) {
		this.entrada = entrada;
	}
}
