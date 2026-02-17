package br.com.danilomendes.interfaces;

public class Soma {


    public static void main(String[] args) {
        Calculadora soma = (a, b) -> a + b;
        System.out.println(soma.calcular(10, 5));

        Calculadora subtrair = (a, b) -> a - b;
        System.out.println(subtrair.calcular(10, 5));
    }
}
