package org.example;

public class ComparadorNumerico {

    private static final double MARGEM_ERRO = 0.01;

    public static boolean saoIguais(double valorEsperado, double valorAtual) {
        return Math.abs(valorEsperado - valorAtual) <= MARGEM_ERRO;
    }
}
