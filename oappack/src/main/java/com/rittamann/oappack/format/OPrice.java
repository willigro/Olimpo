package com.rittamann.oappack.format;

import java.math.BigDecimal;

public class OPrice {

    private static int CASAS_DECIMAIS = 0;

    OPrice(int moedasCasas){
        CASAS_DECIMAIS = moedasCasas;
    }

    /**
     * Utilizando o a contagem do int maximo 2,147,483,647 = 10 casas
     */
    public static String format(double valor) {
        if (valor == 0)
            return "0," + zerosMoeda();

        valor = new BigDecimal(valor).setScale(CASAS_DECIMAIS, BigDecimal.ROUND_HALF_UP).doubleValue();

        String[] realEMoeda = String.valueOf(valor).split("\\.");

        if (realEMoeda.length == 0 || realEMoeda.length == 1)
            return valor + "," + zerosMoeda();

        String moedaFormat = formatarMoedas(realEMoeda[1]);

        int real = Integer.parseInt(realEMoeda[0]);
        char[] forRealFormat = String.valueOf(real).toCharArray();
        boolean negativo = real < 0;
        if (forRealFormat.length < 4 || (forRealFormat.length < 5 && negativo))
            return String.valueOf(real) + "," + moedaFormat;
        else {
            return normalizarLista(inverterListaAplicarPontos(forRealFormat, negativo, real), negativo) + "," + moedaFormat;
        }
    }

    private static String formatarMoedas(String s) {
        if (CASAS_DECIMAIS == 0) return s;
        StringBuilder stringBuilder = new StringBuilder(s);
        for (int i = 0; i < CASAS_DECIMAIS - s.length(); i++) {
            stringBuilder.append("0");
        }
        return stringBuilder.toString();
    }

    private static String zerosMoeda() {
        if (CASAS_DECIMAIS == 0) return "0";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < CASAS_DECIMAIS; i++) {
            stringBuilder.append("0");
        }
        return stringBuilder.toString();
    }

    private static String normalizarLista(StringBuilder listagemInvertidaComPontos, boolean negativo) {
        StringBuilder realFormat = new StringBuilder();
        if (negativo)
            realFormat.append("-");
        char[] realFormatTempoChar = listagemInvertidaComPontos.toString().toCharArray();
        for (int i = 0; i < listagemInvertidaComPontos.length(); i++) {
            realFormat.append(realFormatTempoChar[realFormatTempoChar.length - i - 1]);
        }
        return realFormat.toString();
    }

    private static StringBuilder inverterListaAplicarPontos(char[] forRealFormat, boolean negativo, int real) {
        if (negativo)
            forRealFormat = String.valueOf(real * -1).toCharArray();
        StringBuilder listagemInvertidaComPontos = new StringBuilder();
        for (int i = 0; i < forRealFormat.length; i++) {
            listagemInvertidaComPontos.append(forRealFormat[forRealFormat.length - i - 1]);
            if (i == 2 || i == 5 && forRealFormat.length > 6 || i == 9 && forRealFormat.length > 10) {
                listagemInvertidaComPontos.append(".");
            }
        }
        return listagemInvertidaComPontos;
    }
}
