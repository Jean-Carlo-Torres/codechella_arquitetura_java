package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.application.gateways.RepositorioDeEvento;
import br.com.alura.codechella.domain.entities.Evento;
import br.com.alura.codechella.infra.persistence.EventoEntity;
import br.com.alura.codechella.infra.persistence.EventoRepository;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDeEventoJpa implements RepositorioDeEvento {

    private final EventoRepository repositorio;
    private final EventoEntityMapper mapper;

    public RepositorioDeEventoJpa(EventoRepository repositorio, EventoEntityMapper mapper) {
        this.repositorio = repositorio;
        this.mapper = mapper;
    }

    @Override
    public Evento cadastrarEvento(Evento evento) {
        EventoEntity entity = mapper.toEntity(evento);
        repositorio.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public List<Evento> listarTodos() {
        return repositorio.findAll().stream()
                .map(e -> mapper.toDomain(e))
                .toList();
    }

    @Override
    public Evento atualizarEvento(Long id, Evento evento) {
        return repositorio.findById(id)
                .map(entity -> {
                    entity.setCategoria(evento.getCategoria());
                    entity.setDescricao(evento.getDescricao());
                    entity.setData(evento.getData());
                    entity.setEndereco(evento.getEndereco());
                    entity.setTipoIngressos(new ArrayList<>(evento.getTipoIngressos()));
                    repositorio.save(entity);
                    return mapper.toDomain(entity);
                })
                .orElseThrow(() -> new RuntimeException("Evento não encontrado"));
    }


    @Override
    public void deletarEvento(Long id) {
        repositorio.findById(id)
                .ifPresent(entity -> {
                    repositorio.delete(entity);
                });

    }
}
