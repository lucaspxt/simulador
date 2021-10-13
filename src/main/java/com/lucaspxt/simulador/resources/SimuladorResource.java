package com.lucaspxt.simulador.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lucaspxt.simulador.domain.Simulador;
import com.lucaspxt.simulador.dto.SimuladorDTO;
import com.lucaspxt.simulador.dto.SimuladorResultDTO;
import com.lucaspxt.simulador.services.SimuladorService;
import com.lucaspxt.simulador.services.utils.SimuladorFromDto;

@RestController
@RequestMapping(value="/simulador")
public class SimuladorResource {
	
	private SimuladorFromDto simuladorFromDto = new SimuladorFromDto();
	
	@Autowired
	private SimuladorService simuladorService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> getValorReceber(@Valid @RequestBody SimuladorDTO simuladorDto){
		Simulador simulador = simuladorFromDto.fromDTO(simuladorDto);
		Double valorReceber = simuladorService.getValorReceber(simulador);
		SimuladorResultDTO result = new SimuladorResultDTO(valorReceber, simuladorDto);
		
		return ResponseEntity.ok(result);
	}
	
}
