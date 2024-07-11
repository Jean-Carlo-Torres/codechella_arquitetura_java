package br.com.alura.codechella.infra.controller;

import br.com.alura.codechella.application.usecases.AtualizarUsuario;
import br.com.alura.codechella.application.usecases.CriarUsuario;
import br.com.alura.codechella.application.usecases.DeletarUsuario;
import br.com.alura.codechella.application.usecases.ListarUsuarios;
import br.com.alura.codechella.domain.entities.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final CriarUsuario criarUsuario;
    private final ListarUsuarios listarUsuarios;
    private final AtualizarUsuario atualizarUsuario;
    private final DeletarUsuario deletarUsuario;


    public UsuarioController(CriarUsuario criarUsuario, ListarUsuarios listarUsuarios, AtualizarUsuario atualizarUsuario, DeletarUsuario deletarUsuario) {
        this.criarUsuario = criarUsuario;
        this.listarUsuarios = listarUsuarios;
        this.atualizarUsuario = atualizarUsuario;
        this.deletarUsuario = deletarUsuario;
    }

    @PostMapping
    public UsuarioDto cadastrarUsuario(@RequestBody UsuarioDto dto) {
        Usuario salvo = criarUsuario.cadastrarUsuario(
                new Usuario(dto.cpf(), dto.nome(), dto.nascimento(), dto.email())
        );
        return new UsuarioDto(salvo.getCpf(), salvo.getNome(), salvo.getNascimento(), salvo.getEmail());
    }

    @GetMapping
    public List<UsuarioDto> obterTodosOsUsuarios() {
        List<Usuario> usuarios = listarUsuarios.obterTodosOsUsuarios();
        return usuarios.stream()
                .map(u -> new UsuarioDto(u.getCpf(), u.getNome(), u.getNascimento(), u.getEmail()))
                .toList();
    }

    @PutMapping("/{id}")
    public UsuarioDto atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioDto dto) {
        Usuario atualizado = atualizarUsuario.atualizar(id,
                new Usuario(dto.cpf(), dto.nome(), dto.nascimento(), dto.email()));
        return new UsuarioDto(atualizado.getCpf(), atualizado.getNome(), atualizado.getNascimento(), atualizado.getEmail());
    }

    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable Long id) {
        deletarUsuario.deletar(id);
    }
}
