package com.evolucao.canais.simulator.exception;

import java.util.Collection;

public class Erro {

    public Collection<String> getMessage() {
        return message;
    }

    public void setMessage(Collection<String> message) {
        this.message = message;
    }

    private Collection<String> message;

    public Erro(Collection<String> message) {
        this.message = message;
    }
}
