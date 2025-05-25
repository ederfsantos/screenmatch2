package br.com.eder.screenmatch2;

import br.com.eder.screenmatch2.model.DadosEpisodio;
import br.com.eder.screenmatch2.model.DadosSerie;
import br.com.eder.screenmatch2.model.DadosTemporada;
import br.com.eder.screenmatch2.principal.Principal;
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

    //"https://coffee.alexflipnote.dev/random.json" imagem de cafe
//        //json = consumoApi.obterDados("https://coffee.alexflipnote.dev/random.json");
//        System.out.println(json);
    @Override
    public void run(String... args) throws Exception {

        Principal principal = new Principal();
        principal.exibeMenu();



//        List<DadosTemporada> temporadas = new ArrayList<>();
//        DadosTemporada dadosTemporada;
////https://www.omdbapi.com/?t=grey's+anatomy&Season=1&apikey=2389347b
//        for (int i = 1; i <= dadosSerie.totalTemporadas(); i++) {
//            json = consumoApi.obterDados("https://www.omdbapi.com/?t=vikings&Season=" + i + "&apikey=2389347b");
//            dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
//            temporadas.add(dadosTemporada);
//
//        }
//        //exibindo a lista de temporadas
//        temporadas.forEach(System.out::println);
//        // Gravando em arquivo de texto no formato json o resultado
//        //usando Jackson
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.enable(SerializationFeature.INDENT_OUTPUT);//para vir indentado o json
//        mapper.writeValue(new File("saidaMapperJackson.json"), temporadas);
//
//        //usando Gson
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();//para vir indentado o json
//        // String resposta = gson.toJson(temporadas);
//        // System.out.println(resposta);
//        FileWriter file = new FileWriter("saidaComGson.json");
//        file.write(gson.toJson(temporadas));
//        file.close();
    }
}
