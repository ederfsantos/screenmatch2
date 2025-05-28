package br.com.eder.screenmatch2.exercicios;

@FunctionalInterface
interface Divisor {
    int dividir(int a, int b) throws ArithmeticException;
}

public class ExercicioDivisao {
    public static void main(String[] args) {
        Divisor divisor = (a, b) -> {
            if (b == 0) throw new ArithmeticException("Divisão por zero!");
            return a / b;

        };

        try {
            System.out.println(divisor.dividir(10, 2));
            System.out.println(divisor.dividir(10, 0));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}