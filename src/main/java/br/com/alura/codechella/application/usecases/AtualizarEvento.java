package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.RepositorioDeEvento;
import br.com.alura.codechella.domain.entities.Evento;

public class AtualizarEvento {
    private final RepositorioDeEvento repository;

    public AtualizarEvento(RepositorioDeEvento repository) {
        this.repository = repository;
    }

    public Evento atualizar(Long id, Evento evento) {
        System.out.println("Atualizando evento ID: " + id);
        Evento eventoAtualizado = repository.atualizarEvento(id, evento);
        System.out.println("Evento atualizado: " + eventoAtualizado);
        return eventoAtualizado;
    }
}
