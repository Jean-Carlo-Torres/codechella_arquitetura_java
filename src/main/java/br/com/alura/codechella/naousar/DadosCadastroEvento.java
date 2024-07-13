package br.com.alura.codechella.naousar;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record DadosCadastroEvento(
        @NotNull(message = "A caregoria do evento é obrigatória!")
        Categoria categoria,
        @NotNull(message = "A descrição do evento é obrigatória!")
        String descricao,
        @NotNull(message = "O endereço do evento é obrigatório!")
        DadosEndereco endereco,
        @NotNull(message = "A data do evento é obrigatória!")
        @Future(message = "A data do evento deve ser futura")
        LocalDateTime data,
        @NotNull(message = "Pelo menos um tipo de ingresso deve ser informado!")
        List<DadosCadastroTipoIngresso> tiposIngresso
) {
}
