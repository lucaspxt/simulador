package com.lucaspxt.simulador.services.utils;

import com.lucaspxt.simulador.domain.Simulador;
import com.lucaspxt.simulador.dto.SimuladorDTO;

public class SimuladorFromDto {
	
	public SimuladorFromDto() {
		
	}
	
	public Simulador fromDTO(SimuladorDTO simuladorDTO) {
		Simulador simulador = new Simulador(simuladorDTO.getTaxa()
				,simuladorDTO.getParcelas()
				,simuladorDTO.getValor());
		return simulador;
	}
}
