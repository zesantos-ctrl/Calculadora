package service;

import minhaexcecao.MyException;

public final class Calculadora {
    private Calculadora() {
    }

    public static double soma(double a, double b) {
        return a + b;
    }

    public static double subtrair(double a, double b) {
        return a - b;
    }

    public static double dividir(double a, double b) {
        if (b == 0) {
            throw new MyException("Erro: não é possivel dividir por zero.");
        }
        return a / b;
    }

    public static double multiplicar(double a, double b) {
        return a * b;
    }
}
