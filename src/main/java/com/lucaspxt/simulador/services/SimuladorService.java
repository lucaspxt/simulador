package com.lucaspxt.simulador.services;

import org.springframework.stereotype.Service;

import com.lucaspxt.simulador.domain.Simulador;

@Service
public class SimuladorService {

	public SimuladorService() {
		super();
	}
	
	public Double getValorReceber(Simulador simulador) {
		return simulador.getValor() - this.getValorDescontar(simulador);
	}
	
	public Double getValorDescontar(Simulador simulador) {
		return simulador.getValor() * this.getTaxaTotal(simulador);
	}
	
	public Double getTaxaTotal(Simulador simulador) {
		return simulador.getTaxa() * simulador.getParcelas();
	}
	
	
}
