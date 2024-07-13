package br.com.alura.codechella.naousar;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DadosCadastroTipoIngresso(
        @NotNull(message = "O setor do ingresso é obrigatório!")
        Setor setor,
        Definicao definicao,
        @NotNull
        Double valor,
        @Positive
        int totalDisponivel
) {
}
