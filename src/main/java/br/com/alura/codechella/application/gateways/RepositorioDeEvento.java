package br.com.alura.codechella.application.gateways;

import br.com.alura.codechella.domain.entities.Evento;

import java.util.List;

public interface RepositorioDeEvento {
    Evento cadastrarEvento(Evento evento);

    List<Evento> listarTodos();

    Evento atualizarEvento(Long id, Evento evento);

    void deletarEvento(Long id);
}
