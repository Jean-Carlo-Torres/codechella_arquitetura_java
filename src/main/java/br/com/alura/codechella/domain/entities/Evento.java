package br.com.alura.codechella.domain.entities;

import br.com.alura.codechella.domain.Endereco;
import br.com.alura.codechella.naousar.Categoria;
import br.com.alura.codechella.naousar.DadosCadastroEvento;
import br.com.alura.codechella.naousar.Tipo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Evento {
    private Categoria categoria;
    private String descricao;
    private Endereco endereco;
    private LocalDateTime data;
    private List<Tipo> tipoIngressos = new ArrayList<>();

    public Evento(DadosCadastroEvento dados) {
        this.categoria = dados.categoria();
        this.descricao = dados.descricao();
        this.endereco = new Endereco(dados.endereco());
        this.data = dados.data();
        List<Tipo> tipoIngressos = dados.tiposIngresso().stream()
                .map(i -> new Tipo(i.setor(), i.definicao(), i.valor(), i.totalDisponivel()))
                .toList();
        this.setTipoIngressos(tipoIngressos);
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public List<Tipo> getTipoIngressos() {
        return tipoIngressos;
    }

    public void setTipoIngressos(List<Tipo> tipoIngressos) {
        this.tipoIngressos = tipoIngressos;
    }
}
