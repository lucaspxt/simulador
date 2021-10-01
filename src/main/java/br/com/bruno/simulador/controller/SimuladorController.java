package br.com.bruno.simulador.controller;

import br.com.bruno.simulador.dto.SimulacaoRequest;
import br.com.bruno.simulador.dto.SimulacaoResponse;
import br.com.bruno.simulador.model.Simulacao;
import br.com.bruno.simulador.service.SimulacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigDecimal;

@RestController
@RequestMapping("/api/simulador")
public class SimuladorController {

    @Autowired
    private SimulacaoService simulacaoService;

    /*Simula uma venda com numero da parcela, valor a ser simulado e
    * a forma de pagamento(DEBITO, CREDITOSJUROS, CREDITOCJUROS)
    * e é retornado o valor a receber
    * */
    @GetMapping
    public ResponseEntity<?> simulacaoVenda(@Valid @RequestBody SimulacaoRequest request) {
        return ResponseEntity.ok(new SimulacaoResponse(simulacaoService.geraCalculo(request.toDto())));
    }

}
