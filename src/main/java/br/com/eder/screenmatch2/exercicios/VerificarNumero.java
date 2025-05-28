package br.com.eder.screenmatch2.exercicios;

public class VerificarNumero {

    public void verPrimo(int n) {
        if (n <= 1) {
            System.out.println("Digite um numero positivo e maior que 1");
        } else {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0)
                    System.out.println("O número " + n + " não é primo!");

            }
            System.out.println("O número " + n + " é primo!");
        }
    }
}
