package br.com.alura.codechella.infra.controller;

import br.com.alura.codechella.application.usecases.AtualizarEvento;
import br.com.alura.codechella.application.usecases.CriarEvento;
import br.com.alura.codechella.application.usecases.DeletarEvento;
import br.com.alura.codechella.application.usecases.ListarEventos;
import br.com.alura.codechella.domain.entities.Evento;
import br.com.alura.codechella.naousar.DadosCadastroEvento;
import br.com.alura.codechella.naousar.DadosCadastroTipoIngresso;
import br.com.alura.codechella.naousar.DadosEndereco;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    private final CriarEvento criarEvento;
    private final ListarEventos listarEventos;
    private final AtualizarEvento atualizarEvento;
    private final DeletarEvento deletarEvento;

    public EventoController(CriarEvento criarEvento, ListarEventos listarEventos, AtualizarEvento atualizarEvento, DeletarEvento deletarEvento) {
        this.criarEvento = criarEvento;
        this.listarEventos = listarEventos;
        this.atualizarEvento = atualizarEvento;
        this.deletarEvento = deletarEvento;
    }

    @PostMapping
    public EventoDto cadastrarEvento(@RequestBody EventoDto dto) {
        if (dto.tiposIngresso() == null || dto.tiposIngresso().isEmpty()) {
            throw new IllegalArgumentException("A lista de tipos de ingresso não pode ser nula ou vazia");
        }

        Evento eventoCriado = criarEvento.criarEvento(
                new Evento(
                        new DadosCadastroEvento(
                                dto.categoria(), dto.descricao(), dto.endereco(), dto.data(), dto.tiposIngresso()
                        )
                )
        );
        return new EventoDto(
                eventoCriado.getCategoria(), eventoCriado.getDescricao(),
                new DadosEndereco(
                        eventoCriado.getEndereco().getCep(), eventoCriado.getEndereco().getNumero(), eventoCriado.getEndereco().getComplemento()),
                eventoCriado.getData(), eventoCriado.getTipoIngressos().stream()
                .map(i -> new DadosCadastroTipoIngresso(
                        i.getSetor(), i.getDefinicao(), i.getValor(), i.getTotalDisponivel())
                )
                .toList());
    }

    @GetMapping
    public List<EventoDto> obterTodosEventos() {
        return listarEventos.listarTodosOsEventos().stream()
                .map(e -> new EventoDto(
                        e.getCategoria(), e.getDescricao(),
                        new DadosEndereco(
                                e.getEndereco().getCep(), e.getEndereco().getNumero(), e.getEndereco().getComplemento()),
                        e.getData(), e.getTipoIngressos().stream()
                        .map(i -> new DadosCadastroTipoIngresso(
                                i.getSetor(), i.getDefinicao(), i.getValor(), i.getTotalDisponivel())
                        )
                        .toList()))
                .toList();
    }

    @PutMapping("/{id}")
    public EventoDto atualizarEvento(@PathVariable Long id, @RequestBody EventoDto dto) {

        Evento eventoAtualizado = atualizarEvento.atualizar(
                id,
                new Evento(
                        new DadosCadastroEvento(
                                dto.categoria(), dto.descricao(), dto.endereco(), dto.data(), dto.tiposIngresso()
                        )
                )
        );
        System.out.println("Evento atualizado: " + eventoAtualizado);

        return new EventoDto(
                eventoAtualizado.getCategoria(), eventoAtualizado.getDescricao(),
                new DadosEndereco(
                        eventoAtualizado.getEndereco().getCep(), eventoAtualizado.getEndereco().getNumero(), eventoAtualizado.getEndereco().getComplemento()),
                eventoAtualizado.getData(), eventoAtualizado.getTipoIngressos().stream()
                .map(i -> new DadosCadastroTipoIngresso(
                        i.getSetor(), i.getDefinicao(), i.getValor(), i.getTotalDisponivel())
                )
                .toList());

    }

    @DeleteMapping("/{id}")
    public void deletarEvento(@PathVariable Long id) {
        deletarEvento.deletar(id);
    }
}
