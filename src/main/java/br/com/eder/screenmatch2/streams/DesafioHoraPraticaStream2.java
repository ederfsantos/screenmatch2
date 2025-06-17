package br.com.eder.screenmatch2.streams;

import java.util.*;
import java.util.stream.Collectors;

public class DesafioHoraPraticaStream2 {
    public static void main(String[] args) {

        /*dada a lista de numeros inteiros a seguir, encontre o maior numero dela*/
        List<Integer> numeros = Arrays.asList(10, 20, 30, 40, 50);
        Optional<Integer> maior = numeros.stream().max(Integer::compare);
        maior.ifPresent(System.out::println);//se estiver presente, imprime

        /*dada a lista de palavras(strings) abaixo, agrupe-as pelo seu tamanho.
         * no codigo a seguir, há um exemplo pratico do resultado
         * resultado esperado: {4=[java,code],....}*/

        List<String> palavras = Arrays.asList("java", "stream", "lambda", "code", "collect", "coletas");
        Map<Integer, List<String>> palavrasAgrupadas = palavras.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(palavrasAgrupadas);

        /*dada a lista de nomes abaixo, concatene-os separados por virgula, no codigo a seguir, há um
         * exemplo pratico o resultado esperado*/

        List<String> nomes = Arrays.asList("eder", "joao", "carlos", "marcia", "leticia", "lucas");
        String resultado = nomes.stream().collect(Collectors.joining(", "));
        System.out.println(resultado);
        // nomes.stream().map(n->n.concat(",")).forEach(System.out::print);


        /*dada a lista de numeros inteiros abaixo, calcule a soma dos quadrados dos numeros pares*/

        List<Integer> listaDeNumeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        int soma = listaDeNumeros.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .reduce(0, Integer::sum);
        System.out.println("Soma dos quadrados: " + soma);


        /*dada uma lista de numeros inteiros, separe os numeros pares dos impares*/

        List<Integer> numeros2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        List<Integer> pares = numeros2.stream().filter(n -> n % 2 == 0)
//                .collect(Collectors.toList());
//        System.out.println("Numeros pares: " + pares);
//
//        List<Integer> impares = numeros2.stream().filter(n -> n % 2 != 0)
//                .collect(Collectors.toList());
//        System.out.println("Numeros impares: " + impares);

        Map<Boolean, List<Integer>> particionado = numeros2.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Números pares: " + particionado.get(true));
        System.out.println("Números ímpares: " + particionado.get(false));


        //exercicio 5

        List<Produto> produtos = Arrays.asList(
                new Produto("Iphone", 3000, "Eletronicos"),
                new Produto("Notebook", 550.99, "Eletronicos"),
                new Produto("Mesa", 600.65, "Moveis"),
                new Produto("Cadeira", 306.54, "Moveis"),
                new Produto("Bolacha", 15.50, "Alimento"),
                new Produto("Calculadora", 30, "Eletronicos")
        );

        List<Produto> novalista = produtos.stream()
                .filter(p -> p.getCategoria()
                                     .equalsIgnoreCase("Eletronicos") && p.getPreco() < 1000)
                .sorted(Comparator.comparing(Produto::getPreco)).collect(Collectors.toList());
        System.out.println(novalista);



        //exercicio 6 agrupando por categoria

        Map<String,List<Produto>> agrupadoPorCategoria = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria));
        System.out.println(agrupadoPorCategoria);

        /*dada a lista acima, conte quantos produtos ha em cada categoria e armazene em um
        * Map<String,Long>*/

        Map<String,Long> quantidadePorCategoria = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria,Collectors.counting()));
        System.out.println(quantidadePorCategoria);

        /*dado a lista acima, encontre o produto mais caro de cada categoria e armazene num
        * Map<String, Optional<Produto>>*/

        Map<String,Optional<Produto>> produtoMaisCaroPorCategoria = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria,
                        Collectors.maxBy(Comparator.comparingDouble(Produto::getPreco))));
        System.out.println(produtoMaisCaroPorCategoria);

        /* dada a lista acima, calcule o total dos preços dos produtos em cada categoria e armazene o resultado em um
        * Map<String,Double>*/

        Map<String,Double> totalDePrecos = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria,
                        Collectors.summingDouble(Produto::getPreco)));
        System.out.println(totalDePrecos);


    }
}
