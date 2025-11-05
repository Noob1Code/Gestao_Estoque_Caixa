package com.gestao.back.dto.produto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class ProdutoRequestDTO {

    @NotBlank(message = "Nome é obrigatorio")
    private int codigo;

    @NotBlank(message = "Nome é obrigatorio")
    private String nome;

    @NotBlank(message = "Categoria é obrigatorio")
    private String categoria;

    @NotBlank(message = "Quantidade é obrigatorio")
    @Positive(message = "Quantidade deve ser maior que 0")
    private int quantidadeEstoque;

    @NotBlank(message = "Preço é obrigatorio")
    @Positive(message = "Quantidade deve ser maior que 0")
    private BigDecimal precoUnitario;

    public ProdutoRequestDTO() {
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

}
