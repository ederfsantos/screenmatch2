package br.com.eder.screenmatch2;

import br.com.eder.screenmatch2.model.DadosEpisodio;
import br.com.eder.screenmatch2.model.DadosSerie;
import br.com.eder.screenmatch2.model.DadosTemporada;
import br.com.eder.screenmatch2.service.ConsumoApi;
import br.com.eder.screenmatch2.service.ConverteDados;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Screenmatch2Application implements CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication.run(Screenmatch2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        var consumoApi = new ConsumoApi();
        var json = consumoApi.obterDados("https://www.omdbapi.com/?t=er&apikey=2389347b");
        //System.out.println(json);
        //"https://coffee.alexflipnote.dev/random.json" imagem de cafe
        //json = consumoApi.obterDados("https://coffee.alexflipnote.dev/random.json");
        System.out.println(json);

        ConverteDados conversor = new ConverteDados();
        DadosSerie dadosSerie = conversor.obterDados(json, DadosSerie.class);
        System.out.println(dadosSerie);
        json = consumoApi.obterDados("https://www.omdbapi.com/?t=er&Season=1&episode=1&apikey=2389347b");
        DadosEpisodio dadosEpisodio = conversor.obterDados(json, DadosEpisodio.class);
        System.out.println(dadosEpisodio);

        List<DadosTemporada> temporadas = new ArrayList<>();
        DadosTemporada dadosTemporada;

        for (int i = 1; i <= dadosSerie.totalTemporadas(); i++) {
            json = consumoApi.obterDados("https://www.omdbapi.com/?t=er&Season=" + i + "&apikey=2389347b");
            dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
            temporadas.add(dadosTemporada);

        }
        //exibindo a lista de temporadas
        temporadas.forEach(System.out::println);
        // Gravando em arquivo de texto no formato json o resultado
        //usando Jackson
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);//para vir indentado o json
        mapper.writeValue(new File("saidaMapperJackson.json"), temporadas);
        //System.out.println();

        //usando Gson
        Gson gson = new GsonBuilder().setPrettyPrinting().create();//para vir indentado o json
       // String resposta = gson.toJson(temporadas);
       // System.out.println(resposta);
        FileWriter file = new FileWriter("saidaComGson.json");
        file.write(gson.toJson(temporadas));



    }
}
