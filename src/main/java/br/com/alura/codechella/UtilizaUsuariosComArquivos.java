package br.com.alura.codechella;

import br.com.alura.codechella.domain.entities.Usuario;
import br.com.alura.codechella.infra.gateways.RepositorioDeUsuarioEmArquivo;

import java.time.LocalDate;

public class UtilizaUsuariosComArquivos {
    public static void main(String[] args) {
        RepositorioDeUsuarioEmArquivo repository = new RepositorioDeUsuarioEmArquivo();
        repository.cadastrarUsuario(
                new Usuario("123.456.789-00", "Fulano1", LocalDate.parse("1980-07-21"), "fulano1@gmail.com"));
        repository.cadastrarUsuario(
                new Usuario("123.456.789-01", "Fulano2", LocalDate.parse("1980-07-22"), "fulano2@gmail.com"));
        repository.cadastrarUsuario(
                new Usuario("123.456.789-02", "Fulano3", LocalDate.parse("1980-07-23"), "fulano3@gmail.com"));

        repository.gravarEmArquivo("usuarios.txt");
    }
}
