package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.RepositorioDeEvento;
import br.com.alura.codechella.domain.entities.Evento;

public class CriarEvento {
    private final RepositorioDeEvento repository;

    public CriarEvento(RepositorioDeEvento repository) {
        this.repository = repository;
    }

    public Evento criarEvento(Evento evento) {
        return repository.cadastrarEvento(evento);
    }
}
