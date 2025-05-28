package br.com.eder.screenmatch2.exercicios;


import java.util.Arrays;
import java.util.List;

public class LambdaExercicios {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        System.out.println(numeros);
        numeros.replaceAll(n -> n * 3);
        System.out.println("Após o cálculo");
        System.out.println(numeros);

        //ordenação de Strings

        List<String> nomes = Arrays.asList("João", "Eder", "Maria", "Pedro", "Carla", "Anna");
        System.out.println("Antes da ordenação:\n" + nomes);
        nomes.sort((a, b) -> a.compareTo(b));
        System.out.println("Após a ordenação:\n" + nomes);

    }
}
