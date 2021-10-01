package br.com.bruno.simulador.exception;

public class ErroNaParcelaException extends IllegalArgumentException {

    private static final long serialVersionUID = 1L;

    public ErroNaParcelaException(String mensagem) {
        super(mensagem);
    }

}
