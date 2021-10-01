package br.com.bruno.simulador.service;

import br.com.bruno.simulador.model.Simulacao;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.math.BigDecimal;

@Service
public class SimulacaoService {

    //Realiza o calculo de juros, a taxa de juros e fixa para cada tipo de forma de pagamento
    public BigDecimal geraCalculo(@Valid Simulacao request) {
        return request.formaPagamento(request.getValorSimulado(), request.getParcelaDaVenda());
    }
}
