package com.gestao.back.dto.MovimentoProduto;

import com.gestao.back.model.entities.MovimentoEstoque;
import com.gestao.back.model.entities.Produto;
import com.gestao.back.model.entities.Usuario;
import com.gestao.back.model.enums.TipoMovimento;

import java.time.LocalDateTime;

public class MovimentoEstoqueResponseDTO {

    private Long id;
    private int quantidade;
    private Produto produto;
    private TipoMovimento tipoMovimento;
    private LocalDateTime data;
    private String Motivo;
    private Usuario usuarioId;

    public MovimentoEstoqueResponseDTO(MovimentoEstoque movimentoEstoque) {
        this.id = movimentoEstoque.getId();
        this.quantidade = movimentoEstoque.getQuantidade();
        this.produto = movimentoEstoque.getProduto();
        this.tipoMovimento = movimentoEstoque.getTipoMovimento();
        this.data = movimentoEstoque.getData();
        this.Motivo = movimentoEstoque.getMotivo();
        this.usuarioId = movimentoEstoque.getUsuario();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public TipoMovimento getTipoMovimento() {
        return tipoMovimento;
    }

    public void setTipoMovimento(TipoMovimento tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getMotivo() {
        return Motivo;
    }

    public void setMotivo(String motivo) {
        Motivo = motivo;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }
}
