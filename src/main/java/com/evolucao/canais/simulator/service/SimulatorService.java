package com.evolucao.canais.simulator.service;

import com.evolucao.canais.simulator.model.Parametros;
import org.springframework.stereotype.Service;

@Service
public class SimulatorService {


    public Float calcular(Parametros parametros) {

    Float calculando = parametros.getValor() - (parametros.getTaxa() * parametros.getQtdParcelas() * parametros.getValor() / 100);

    return calculando;

    }
}
