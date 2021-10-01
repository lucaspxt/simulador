package br.com.bruno.simulador.exception;

public class ErroEnumException extends IllegalArgumentException {

    private static final long serialVersionUID = 1L;

    public ErroEnumException(String mensagem) {
        super(mensagem);
    }

}
