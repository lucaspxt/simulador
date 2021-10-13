package com.lucaspxt.simulador.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class SimuladorTest {
	
	@Test
	public void newSimuladorTest() {
		Simulador simulador = new Simulador(0.018, 12, 1000.00);
		
		Assertions.assertEquals(simulador.getTaxa(), 0.018);
		Assertions.assertEquals(simulador.getParcelas(), 12);
		Assertions.assertEquals(simulador.getValor(), 1000.00);
	}
}
