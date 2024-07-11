package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;

public class DeletarUsuario {
    private final RepositorioDeUsuario repository;

    public DeletarUsuario(RepositorioDeUsuario repository) {
        this.repository = repository;
    }

    public void deletar(Long id) {
        repository.deletarUsuario(id);
    }
}
