package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.Usuario;

public class AtualizarUsuario {

    private final RepositorioDeUsuario repository;

    public AtualizarUsuario(RepositorioDeUsuario repository) {
        this.repository = repository;
    }

    public Usuario atualizar(Long id, Usuario usuario) {
        return repository.atualizarUsuario(id, usuario);
    }
}
