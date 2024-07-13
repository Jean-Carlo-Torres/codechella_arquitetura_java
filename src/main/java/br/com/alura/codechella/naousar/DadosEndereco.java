package br.com.alura.codechella.naousar;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record DadosEndereco(
        @NotBlank(message = "O CEP é obrigatório!")
        String cep,
        @Positive(message = "O número é obrigatório!")
        Integer numero,
        String complemento
) {
}