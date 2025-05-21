package br.com.eder.screenmatch2.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//anotação para ignorar dados não mapeados
@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSerie(@JsonAlias("Title") String titulo, @JsonAlias("totalSeasons")
Integer totalTemporadas, @JsonAlias("imdbRating") String avaliacao) {
}
