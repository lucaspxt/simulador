package com.lucaspxt.simulador.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.lucaspxt.simulador.domain.Simulador;

@ExtendWith(SpringExtension.class)
public class SimuladorServiceTest {

	@Test
	public void valorReceberTest() {
		Simulador simulador = new Simulador(0.021, 12, 1000.00);
		SimuladorService simuladorService = new SimuladorService();
		
		Assertions.assertEquals(748.00, simuladorService.getValorReceber(simulador));
	}
}
