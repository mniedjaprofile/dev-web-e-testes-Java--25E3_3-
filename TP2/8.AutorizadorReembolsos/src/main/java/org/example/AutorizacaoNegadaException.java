package org.example;

public class AutorizacaoNegadaException extends RuntimeException {
    public AutorizacaoNegadaException(String mensagem) {
        super(mensagem);
    }
}