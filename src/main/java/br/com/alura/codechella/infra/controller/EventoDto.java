package br.com.alura.codechella.infra.controller;

import br.com.alura.codechella.naousar.Categoria;
import br.com.alura.codechella.naousar.DadosCadastroTipoIngresso;
import br.com.alura.codechella.naousar.DadosEndereco;

import java.time.LocalDateTime;
import java.util.List;

public record EventoDto(
        Categoria categoria,
        String descricao,
        DadosEndereco endereco,
        LocalDateTime data,
        List<DadosCadastroTipoIngresso> tiposIngresso
) {
}
