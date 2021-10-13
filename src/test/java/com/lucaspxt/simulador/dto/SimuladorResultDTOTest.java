package com.lucaspxt.simulador.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class SimuladorResultDTOTest {
	
	@Test
	public void newSimuladorResultDTOTest() {
		SimuladorDTO simuladorDto = new SimuladorDTO(0.018, 12, 1000.00);
		SimuladorResultDTO simuladorResultDto = new SimuladorResultDTO(1000.00, simuladorDto);
		
		Assertions.assertEquals(simuladorResultDto.getResultado(), 1000.00);
		Assertions.assertEquals(simuladorResultDto.getEntrada(), simuladorDto);
	}
}
