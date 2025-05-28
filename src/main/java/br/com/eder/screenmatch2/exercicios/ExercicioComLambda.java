package br.com.eder.screenmatch2.exercicios;

@FunctionalInterface
interface Multiplicacao {
    int multiplicacao(int a, int b);
}

@FunctionalInterface
interface Soma {
    int soma(int a, int b);
}
@FunctionalInterface
interface Primo {
    boolean verificaSePrimo(int n);
}
@FunctionalInterface
interface Transformador {
    String transformar(String s);
}
@FunctionalInterface
interface Palindromo{
    boolean verificarPalindromo(String str);
}

public class ExercicioComLambda {

    public static void main(String[] args) {
        Soma soma = Integer::sum;
        //Soma soma = (a, b) -> a + b; essa linha faz a mesma coisa que a de cima
        System.out.println("O resultado da soma é : " + soma.soma(5, 3));

        Primo primo = n -> {
            if (n <= 1) return false;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) return false;
            }
            return true;
        };
        System.out.println(primo.verificaSePrimo(1));
        System.out.println(primo.verificaSePrimo(1));


        Transformador toUpperCase = s -> s.toUpperCase();

        System.out.println(toUpperCase.transformar("java spring"));



        Palindromo palindromo = str -> str.equals(new StringBuilder(str).reverse().toString());
        System.out.println(palindromo.verificarPalindromo("radar"));
        System.out.println(palindromo.verificarPalindromo("java"));



        }


    }

