package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.Usuario;
import br.com.alura.codechella.infra.persistence.UsuarioEntity;
import br.com.alura.codechella.infra.persistence.UsuarioRepository;

import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDeUsuarioJpa implements RepositorioDeUsuario {

    private final UsuarioRepository repository;
    private final UsuarioEntityMapper mapper;

    public RepositorioDeUsuarioJpa(UsuarioRepository repository, UsuarioEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        UsuarioEntity entity = mapper.toEntity(usuario);
        repository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public List<Usuario> listarTodos() {
        return repository.findAll().stream()
                .map(u -> mapper.toDomain(u))
                .collect(Collectors.toList());
    }

    @Override
    public Usuario atualizarUsuario(Long id, Usuario usuario) {
        return repository.findById(id)
                .map(entity -> {
                    entity.setCpf(usuario.getCpf());
                    entity.setNome(usuario.getNome());
                    entity.setNascimento(usuario.getNascimento());
                    entity.setEmail(usuario.getEmail());
                    repository.save(entity);
                    return mapper.toDomain(entity);
                })
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
    }

    @Override
    public void deletarUsuario(Long id) {
        repository.findById(id)
                .ifPresent(entity -> {
                    repository.delete(entity);
                });
    }
}
