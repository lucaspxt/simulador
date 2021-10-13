package com.lucaspxt.simulador.resources;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucaspxt.simulador.dto.SimuladorDTO;

@SpringBootTest
@AutoConfigureMockMvc
public class SimuladorResourceTest {

	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	public void getValorReceberTest() throws JsonProcessingException, Exception {
		SimuladorDTO simuladorDto = new SimuladorDTO(0.018, 12, 1000.00);
		
		mockMvc.perform(post("/simulador")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(simuladorDto)))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.resultado").value(784.0));
	}
}
