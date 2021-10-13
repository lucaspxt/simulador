package com.lucaspxt.simulador.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lucaspxt.simulador.dto.SimuladorDTO;
import com.lucaspxt.simulador.resources.exceptions.FieldMessage;

public class SimuladorVerifyValidator implements ConstraintValidator<SimuladorVerify, SimuladorDTO> {
	
	@Override
	public void initialize(SimuladorVerify ann) {
		
	}
	
	@Override
	public boolean isValid(SimuladorDTO simuladorDto, ConstraintValidatorContext context) {
		List<FieldMessage> fieldMessagelist = new ArrayList<>();
		if (simuladorDto.getTaxa() == null) {
			fieldMessagelist.add(new FieldMessage("taxa", "Uma taxa deve ser informada!"));
		}
		
		if (simuladorDto.getParcelas() == null) {
			fieldMessagelist.add(new FieldMessage("parcelas", "A quantidade de parcelas deve ser informada!"));
		}
		
		if (simuladorDto.getValor() == null) {
			fieldMessagelist.add(new FieldMessage("valor", "Um valor deve ser informada!"));
		}
		
		return this.buildMessageError(fieldMessagelist, context);
	}
	
	public boolean buildMessageError(List<FieldMessage> fieldMessagelist, ConstraintValidatorContext context) {
		for (FieldMessage e : fieldMessagelist) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMsg()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		
		return fieldMessagelist.isEmpty();
	}
}
