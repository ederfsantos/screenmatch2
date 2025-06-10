package br.com.eder.screenmatch2.streams;

import com.sun.tools.javac.Main;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ExerciciosComStream {
    public static void main(String[] args) {
        //ex 1 - Dada a lista abaixo, filtre apenas os numeros pares e exiba - os.

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);
        numeros.stream().filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        /** ex 2 - Dada a lista de strings abaixo, converta todas para letras maiusculas
         *e imprima-as.
         */

        List<String> palavras = Arrays.asList("java", "stream", "lambda");
        palavras.stream().map(String::toUpperCase).forEach(System.out::println);

        /**
         * ex 3 - Dada a lista de inteiros abaixo, filtre os numeros impares, multiplique
         * cada um por 2 e colete os resultados em uma nova lista
         */

        List<Integer> listaDeNumeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> novaLista = listaDeNumeros.stream()
                .filter(n -> n % 2 != 0)
                .map(n -> n * 2)
                .collect(Collectors.toList());
        //novaLista.forEach(System.out::println);
        System.out.println(novaLista);


        /**
         * ex 4 - Dada a lista abaixo, remova as duplicatas(palavras que aparecem mais
         * vez) e  imprima o resultado
         */
        List<String> listaDePalavras = Arrays.asList("apple", "banana", "apple", "orange", "banana");
        listaDePalavras.stream().distinct().forEach(System.out::println);

        /** ex 5 - Dada a lista de sublistas de numeros inteiros abaixo, extraia todos os numeros primos em uma
         * unica lista e os ordene em ordem crescente.
         *
         */

        List<List<Integer>> listaDeNumerosInteiros = Arrays.asList(
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(5, 6, 7, 8),
                Arrays.asList(9, 10, 11, 12)
        );

        List<Integer> listaDeNumerosPrimos = listaDeNumerosInteiros.stream()
                .flatMap(List::stream)
                .filter(ExerciciosComStream::verificaNumeroPrimo)
                .sorted().collect(Collectors.toList());
        System.out.println(listaDeNumerosPrimos);

/**
 * ex 6 - dado um obeto pessoa com os campos nome e idade, filtre as pessoas com mais de
 * 18 anos, extraia os nomes e imprima-os em ordem alfabetica, a classe pessoa esta definida
 */
        List<Pessoa> pessoas = Arrays.asList(new Pessoa("Alice", 22),
                new Pessoa("Bob", 17), new Pessoa("Charlie", 19));

        pessoas.stream().filter(p -> p.getIdade() > 18)
                .map(Pessoa::getNome).sorted().forEach(System.out::println);


        /**
         * ex 7 - voce te uma lista de produtos, onde cada produto possui os atributos
         * nome(string), preco(double) e categoria(String).Filtre todos os produtos
         * da categoria "eletronicos" com preço menor que R$1000, ordene-os pelo preço
         * em ordem crescente e colete o resultado em uma nova lista.
         */

        List<Produto> produtos = Arrays.asList(
                new Produto("Smartphone", 800.0, "Eletronicos"),
                new Produto("Notebook", 1500.0, "Eletronicos"),
                new Produto("Teclado", 200.0, "Eletronicos"),
                new Produto("Cadeira", 300.0, "Moveis"),
                new Produto("Monitor", 900.0, "Eletronicos"),
                new Produto("Mouse", 30.0, "Eletronicos"),
                new Produto("Mesa", 700.0, "Moveis")
        );

        List<Produto> novaListaDeProdutos = produtos.stream()
                .filter(p -> p.getCategoria().equalsIgnoreCase("Eletronicos"))
                .filter(p -> p.getPreco() < 1000).sorted(Comparator.comparing(Produto::getPreco))
                .collect(Collectors.toList());
        System.out.println(novaListaDeProdutos);

        /** ex 8 - tomando o mesmo codigo do ex 7, modifique para que a saida mostre apenas os tres produtos
         * mais baratos da categoria "eletronicos"
         *
         */
        List<Produto> novaListaDeProdutosBaratos = produtos.stream()
                .filter(p -> p.getCategoria().equalsIgnoreCase("Eletronicos"))
                .filter(p -> p.getPreco() < 1000).sorted(Comparator.comparing(Produto::getPreco))
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(novaListaDeProdutosBaratos);



    }

    private static boolean verificaNumeroPrimo(int numero) {
        double raiz = Math.sqrt(numero);
        if (numero < 2)
            return false;//numeros menores que 2 nao sao primos
        for (int i = 2; i <= raiz; i++) {
            if (numero % i == 0) {
                return false;//divisivel por outro numero que nao 1 e ele mesmo nao é primo

            }
        }
        return true;
    }
}
/**
 * for (int i = 2; i <= Math.sqrt(n); i++) {
 * if (n % i == 0)
 * System.out.println("O número " + n + " não é primo!");
 * <p>
 * }
 * System.out.println("O número " + n + " é primo!");
 */




