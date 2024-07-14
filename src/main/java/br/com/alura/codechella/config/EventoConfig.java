package br.com.alura.codechella.config;

import br.com.alura.codechella.application.gateways.RepositorioDeEvento;
import br.com.alura.codechella.application.usecases.AtualizarEvento;
import br.com.alura.codechella.application.usecases.CriarEvento;
import br.com.alura.codechella.application.usecases.DeletarEvento;
import br.com.alura.codechella.application.usecases.ListarEventos;
import br.com.alura.codechella.infra.gateways.EventoEntityMapper;
import br.com.alura.codechella.infra.gateways.RepositorioDeEventoJpa;
import br.com.alura.codechella.infra.persistence.EventoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventoConfig {

    @Bean
    CriarEvento criarEvento(RepositorioDeEvento repositorioDeEvento) {
        return new CriarEvento(repositorioDeEvento);
    }

    @Bean
    ListarEventos listarEventos(RepositorioDeEvento repositorioDeEvento) {
        return new ListarEventos(repositorioDeEvento);
    }

    @Bean
    AtualizarEvento atualizarEvento(RepositorioDeEvento repositorioDeEvento) {
        return new AtualizarEvento(repositorioDeEvento);
    }

    @Bean
    DeletarEvento deletarEvento(RepositorioDeEvento repositorioDeEvento) {
        return new DeletarEvento(repositorioDeEvento);
    }

    @Bean
    RepositorioDeEventoJpa criarRepositorioDeEvento(EventoRepository repositorio, EventoEntityMapper mapper) {
        return new RepositorioDeEventoJpa(repositorio, mapper);
    }

    @Bean
    EventoEntityMapper retornaEventoMapper() {
        return new EventoEntityMapper();
    }
}
