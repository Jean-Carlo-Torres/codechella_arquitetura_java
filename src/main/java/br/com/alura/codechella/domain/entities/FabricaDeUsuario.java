package br.com.alura.codechella.domain.entities;

import br.com.alura.codechella.domain.Endereco;
import br.com.alura.codechella.naousar.DadosEndereco;

import java.time.LocalDate;

public class FabricaDeUsuario {
    private Usuario usuario;

    public Usuario comNomeCpfNascimento(String cpf, String nome, LocalDate nascimento, String email) {
        this.usuario = new Usuario(cpf, nome, nascimento, email);
        return this.usuario;
    }

    public Usuario incluiEndereco(String cep, Integer numero, String complemento) {
        this.usuario.setEndereco(new Endereco(
                new DadosEndereco(cep, numero, complemento)
        ));
        return this.usuario;
    }
}
