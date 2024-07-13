package br.com.alura.codechella.naousar;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tipo_ingresso")
public class Tipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JsonIgnore
    private Evento evento;
    @Enumerated(EnumType.STRING)
    private Setor setor;
    @Enumerated(EnumType.STRING)
    private Definicao definicao;
    private double valor;
    private int totalDisponivel;

    @OneToMany(mappedBy = "tipo", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Ingresso> ingressos = new ArrayList<>();

    private Tipo(){
    }

    public Tipo(Setor setor, Definicao definicao, double valor, int totalDisponivel) {
        this.setor = setor;
        this.definicao = definicao;
        this.valor = valor;
        this.totalDisponivel = totalDisponivel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public Definicao getDefinicao() {
        return definicao;
    }

    public void setDefinicao(Definicao definicao) {
        this.definicao = definicao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getTotalDisponivel() {
        return totalDisponivel;
    }

    public void setTotalDisponivel(int totalDisponivel) {
        this.totalDisponivel = totalDisponivel;
    }

    public List<Ingresso> getIngressos() {
        return ingressos;
    }

    public void setIngressos(List<Ingresso> ingressos) {
        ingressos.forEach(i -> i.setTipo(this));
        this.ingressos = ingressos;
    }
}
