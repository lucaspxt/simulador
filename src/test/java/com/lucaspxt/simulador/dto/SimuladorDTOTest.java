package com.lucaspxt.simulador.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class SimuladorDTOTest {

	@Test
	public void newSimuladorDTOTest() {
		SimuladorDTO simuladorDto = new SimuladorDTO(0.018, 12, 1000.00);
		
		Assertions.assertEquals(simuladorDto.getTaxa(), 0.018);
		Assertions.assertEquals(simuladorDto.getParcelas(), 12);
		Assertions.assertEquals(simuladorDto.getValor(), 1000.00);
	}
}
