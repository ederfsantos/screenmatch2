package br.com.eder.screenmatch2.principal;

import br.com.eder.screenmatch2.model.DadosEpisodio;
import br.com.eder.screenmatch2.model.DadosSerie;
import br.com.eder.screenmatch2.model.DadosTemporada;
import br.com.eder.screenmatch2.model.Episodio;
import br.com.eder.screenmatch2.service.ConsumoApi;
import br.com.eder.screenmatch2.service.ConverteDados;
import ch.qos.logback.core.encoder.JsonEscapeUtil;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=2389347b";

    public void exibeMenu() {
        System.out.println("Digite o nome da série para consultar: ");
        var nomeSerie = leitura.nextLine();
        var json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
        DadosSerie dadosSerie = conversor.obterDados(json, DadosSerie.class);
      //  System.out.println(dadosSerie);
        //ENDERECO + nomeSerie.replace(" ","+")+API_KEY;
        //"https://www.omdbapi.com/?t=vikings&apikey=2389347b"
        List<DadosTemporada> temporadas = new ArrayList<>();
        DadosTemporada dadosTemporada;
//https://www.omdbapi.com/?t=grey's+anatomy&Season=1&apikey=2389347b
        for (int i = 1; i <= dadosSerie.totalTemporadas(); i++) {
            json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&Season=" + i + API_KEY);
            dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
            temporadas.add(dadosTemporada);

        }
//        System.out.println("\nExibindo a lista de temporadas com forEach");
//        temporadas.forEach(System.out::println);
//        System.out.println("\nExibindo os titulos com for dentro de for");
//        List<DadosEpisodio> episodiosTemporada;
//        for (int i = 0; i < dadosSerie.totalTemporadas(); i++) {
//            episodiosTemporada = temporadas.get(i).episodios();
//            for (int j = 0; j < episodiosTemporada.size(); j++) {
//                System.out.println(episodiosTemporada.get(j).titulo());
//            }
//        }
//        System.out.println("\nExibindo a saida com forEach somente os titulos");
//        temporadas.forEach(t -> t.episodios().forEach(e ->
//                System.out.println(e.titulo())));

//        List<String> nomes = Arrays.asList("jonas","Jacque","Iasmin","Paulo","Rodrigo","Nico","Sarah Connor","Eder");
//        nomes.stream().sorted().forEach(System.out::println);//ordenando a lista no fluxo stream
//        System.out.println("\n");
//        nomes.stream().sorted().limit(3).forEach(System.out::println);
//        System.out.println("\n");
//        nomes.stream().sorted().limit(3).filter(n->n.startsWith("J"))
//                .map(n->n.toUpperCase()).forEach(System.out::println);


        //vamos armazenar todos os episodios em uma unica lista
        List<DadosEpisodio> dadosEpisodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream())
                .collect(Collectors.toList());
        System.out.println(dadosEpisodios);
        //.toList();
//toList() devolve uma coleção imutavel, nao da pra add objetos
//        dadosEpisodios.add(new DadosEpisodio("teste",3,"10","2025-02-12"));
//        dadosEpisodios.forEach(System.out::println);

        System.out.println("\nTop 10 episódios");
        dadosEpisodios.stream()
                .filter(e -> !e.avaliacao().equalsIgnoreCase("N/A"))
                .peek(e-> System.out.println("Primeiro filtro(N/A) " + e))
                .sorted(Comparator.comparing(DadosEpisodio::avaliacao).reversed())
                .peek(e-> System.out.println("Ordenação " + e))
                .limit(10)
                .peek(e-> System.out.println("Limite " + e))
                .map(e->e.titulo().toUpperCase())
                .peek(e-> System.out.println("Mapeamento " + e))//função peek para debugar " uma olhada no que esta acontecendo nesse ponto"
                .forEach(System.out::println);

//        List<Episodio> episodios = temporadas.stream()
//                .flatMap(t -> t.episodios().stream())
//                .map(d -> new Episodio(d.numeroEpisodio(), d)).collect(Collectors.toList());
//
//        episodios.forEach(System.out::println);

//        System.out.println("\nApartir de que ano você deseja ver os episodios? ");
//        var ano = leitura.nextInt();
//        leitura.nextLine();
//        LocalDate dataBusca = LocalDate.of(ano, 1, 1);
//        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        episodios.stream()
//                .filter(e -> e.getDataLancamento() != null && e.getDataLancamento().isAfter(dataBusca))
//                .forEach(e -> System.out.println(
//                        " Temporada: " + e.getTemporada() +
//                        " Episódio: " + e.getTitulo() +
//                        " Data de Lançamento: " + e.getDataLancamento().format(df)
//                ));
//

    }
}
