package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.domain.entities.Evento;
import br.com.alura.codechella.infra.persistence.EventoEntity;
import br.com.alura.codechella.naousar.DadosCadastroEvento;
import br.com.alura.codechella.naousar.DadosCadastroTipoIngresso;
import br.com.alura.codechella.naousar.DadosEndereco;

import java.util.ArrayList;

public class EventoEntityMapper {

    EventoEntity toEntity(Evento evento) {
        return new EventoEntity(
                new DadosCadastroEvento(
                        evento.getCategoria(), evento.getDescricao(),
                        new DadosEndereco(
                                evento.getEndereco().getCep(), evento.getEndereco().getNumero(), evento.getEndereco().getComplemento()),
                        evento.getData(), new ArrayList<>(evento.getTipoIngressos().stream()
                        .map(i -> new DadosCadastroTipoIngresso(
                                i.getSetor(), i.getDefinicao(), i.getValor(), i.getTotalDisponivel())
                        )
                        .toList())
                )
        );
    }

    public Evento toDomain(EventoEntity entity){
        return new Evento(
                new DadosCadastroEvento(
                        entity.getCategoria(), entity.getDescricao(),
                        new DadosEndereco(
                                entity.getEndereco().getCep(), entity.getEndereco().getNumero(), entity.getEndereco().getComplemento()),
                        entity.getData(), new ArrayList<>(entity.getTipoIngressos().stream()
                        .map(i -> new DadosCadastroTipoIngresso(
                                i.getSetor(), i.getDefinicao(), i.getValor(), i.getTotalDisponivel())
                        )
                        .toList())
                )
        );
    }
}
