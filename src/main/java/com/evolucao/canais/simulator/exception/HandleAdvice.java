package com.evolucao.canais.simulator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

@RestControllerAdvice
public class HandleAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handle(MethodArgumentNotValidException exception) {

        Collection<String> message = new ArrayList<>();
        BindingResult bindingResult = exception.getBindingResult();
        List<FieldError> listaErros = bindingResult.getFieldErrors();

        listaErros.forEach(erros -> {

            String format = String.format(erros.getDefaultMessage());
            message.add(format);

        });

        Erro erro = new Erro(message);


        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<?> handleResponseStatus(ResponseStatusException responseStatusException) {

        Collection<String> message = new ArrayList<>();
        message.add(responseStatusException.getReason());

        Erro erro = new Erro(message);

        return ResponseEntity.status(responseStatusException.getStatus()).body(erro);

    }



}
