package com.lucaspxt.simulador.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

import com.lucaspxt.simulador.dto.SimuladorDTO;
import com.lucaspxt.simulador.dto.SimuladorResultDTO;

public class SimuladorResultError {
	
	private List<FieldMessage> errors = new ArrayList<>();
	
	public SimuladorResultError() {
		super();
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addErrors(String fieldName, String msg) {
		errors.add(new FieldMessage(fieldName, msg));
	}
	
}
