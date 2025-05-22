package br.com.eder.screenmatch2;

import br.com.eder.screenmatch2.model.DadosEpisodio;
import br.com.eder.screenmatch2.model.DadosSerie;
import br.com.eder.screenmatch2.service.ConsumoApi;
import br.com.eder.screenmatch2.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Screenmatch2Application implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(Screenmatch2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=er&apikey=2389347b");
		var json1 = consumoApi.obterDados("https://www.omdbapi.com/?t=er&Season=1&episode=1&apikey=2389347b");
		//System.out.println(json);
		//"https://coffee.alexflipnote.dev/random.json" imagem de cafe
		//json = consumoApi.obterDados("https://coffee.alexflipnote.dev/random.json");
		System.out.println(json);

		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json,DadosSerie.class);
		System.out.println(dados);
		DadosEpisodio dadosEpisodio = conversor.obterDados(json1,DadosEpisodio.class);
		System.out.println(dadosEpisodio);


	}
}
