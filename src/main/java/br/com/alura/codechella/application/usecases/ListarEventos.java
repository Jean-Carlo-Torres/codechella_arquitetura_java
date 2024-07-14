package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.RepositorioDeEvento;
import br.com.alura.codechella.domain.entities.Evento;

import java.util.List;

public class ListarEventos {
    private final RepositorioDeEvento repository;

    public ListarEventos(RepositorioDeEvento repository) {
        this.repository = repository;
    }

    public List<Evento> listarTodosOsEventos() {
        return repository.listarTodos();
    }
}
