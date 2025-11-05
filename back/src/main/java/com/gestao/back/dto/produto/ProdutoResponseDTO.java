package com.gestao.back.dto.produto;

import java.math.BigDecimal;

import com.gestao.back.model.entities.Produto;

public class ProdutoResponseDTO {

    private long id;
    private int codigo;
    private String nome;
    private String categoria;
    private int quantidadeEstoque;
    private BigDecimal precoUnitario;

    public ProdutoResponseDTO() {
    }

    public ProdutoResponseDTO(Produto produto) {
        this.categoria = produto.getCategoria();
        this.codigo = produto.getCodigo();
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.precoUnitario = produto.getPrecoUnitario();
        this.quantidadeEstoque = produto.getQuantidadeEstoque();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
