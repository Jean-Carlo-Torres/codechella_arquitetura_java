package br.com.alura.codechella.naousar;

import br.com.alura.codechella.domain.entities.Usuario;
import br.com.alura.codechella.infra.persistence.UsuarioEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vendas")
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @ManyToOne
//    @JoinColumn(name = "usuario_id")
//    private Usuario usuario;
//    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private List<Ingresso> ingressos = new ArrayList<>();
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Usuario getUsuario() {
//        return usuario;
//    }
//
//    public void setUsuario(UsuarioEntity usuario) {
////        this.usuario = usuario;
//    }
//
//    public List<Ingresso> getIngressos() {
//        return ingressos;
//    }
//
//    public void setIngressos(List<Ingresso> ingressos) {
//        ingressos.forEach(i -> i.setVenda(this));
//        this.ingressos = ingressos;
//    }
}
