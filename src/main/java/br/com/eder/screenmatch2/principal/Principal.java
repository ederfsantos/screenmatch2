package br.com.eder.screenmatch2.principal;

import br.com.eder.screenmatch2.model.DadosEpisodio;
import br.com.eder.screenmatch2.model.DadosSerie;
import br.com.eder.screenmatch2.model.DadosTemporada;
import br.com.eder.screenmatch2.service.ConsumoApi;
import br.com.eder.screenmatch2.service.ConverteDados;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=2389347b";

    public void exibeMenu() {
//        System.out.println("Digie o nome da série para consultar: ");
//        var nomeSerie = leitura.nextLine();
//        var json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
//        DadosSerie dadosSerie = conversor.obterDados(json, DadosSerie.class);
//        System.out.println(dadosSerie);
//        //ENDERECO + nomeSerie.replace(" ","+")+API_KEY;
//        //"https://www.omdbapi.com/?t=vikings&apikey=2389347b"
//        List<DadosTemporada> temporadas = new ArrayList<>();
//        DadosTemporada dadosTemporada;
////https://www.omdbapi.com/?t=grey's+anatomy&Season=1&apikey=2389347b
//        for (int i = 1; i <= dadosSerie.totalTemporadas(); i++) {
//            json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&Season=" + i + API_KEY);
//            dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
//            temporadas.add(dadosTemporada);
//
//        }
//        temporadas.forEach(System.out::println);
//
////        List<DadosEpisodio> episodiosTemporada;
////        for (int i = 0; i < dadosSerie.totalTemporadas(); i++) {
////            episodiosTemporada = temporadas.get(i).episodios();
////            for (int j = 0; j < episodiosTemporada.size(); j++) {
////                System.out.println(episodiosTemporada.get(j).titulo());
////            }
////        }
//
//        temporadas.forEach(t ->t.episodios().forEach(e->
//                System.out.println(e.titulo())));

        List<String> nomes = Arrays.asList("Jacque","Iasmin","Paulo","Rodrigo","Nico");
        nomes.stream().sorted().forEach(System.out::println);
        System.out.println("\n");
        nomes.stream().sorted().limit(3).forEach(System.out::println);
        System.out.println("\n");
        nomes.stream().sorted().limit(3).filter(n->n.startsWith("N"))
                .map(n->n.toUpperCase()).forEach(System.out::println);
    }
}
