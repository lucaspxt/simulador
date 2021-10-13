package com.lucaspxt.simulador.services.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.lucaspxt.simulador.domain.Simulador;
import com.lucaspxt.simulador.dto.SimuladorDTO;

@ExtendWith(SpringExtension.class)
public class SimuladorFromDtoTest {
	
	SimuladorFromDto simuladorFromDto = new SimuladorFromDto();
	
	@Test
	public void fromDTOTest() {
		SimuladorDTO simuladorDTO = new SimuladorDTO(1.8, 12, 100.00);
		Simulador simulador = simuladorFromDto.fromDTO(simuladorDTO);
		
		Assertions.assertEquals(1.8, simulador.getTaxa());
		Assertions.assertEquals(12, simulador.getParcelas());
		Assertions.assertEquals(100.00, simulador.getValor());
	}

}
