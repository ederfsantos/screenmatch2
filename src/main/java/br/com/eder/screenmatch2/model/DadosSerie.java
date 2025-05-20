package br.com.eder.screenmatch2.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DadosSerie(@JsonAlias("Title") String titulo, @JsonAlias("totalSeasons")
Integer totalTemporadas, @JsonAlias("imdbRating") String avaliacao) {
}
