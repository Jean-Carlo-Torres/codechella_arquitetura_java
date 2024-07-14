package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.RepositorioDeEvento;

public class DeletarEvento {
    private final RepositorioDeEvento repository;

    public DeletarEvento(RepositorioDeEvento repository) {
        this.repository = repository;
    }

    public void deletar(Long id) {
        repository.deletarEvento(id);
    }
}
