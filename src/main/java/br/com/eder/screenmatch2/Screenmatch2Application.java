package br.com.eder.screenmatch2;

import br.com.eder.screenmatch2.service.ConsumoApi;
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
		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=er&Season=1&apikey=2389347b");
		System.out.println(json);
		//"https://coffee.alexflipnote.dev/random.json" imagem de cafe
//		json = consumoApi.obterDados("https://coffee.alexflipnote.dev/random.json");
//		System.out.println(json);


	}
}
