package com.gestao.back.dto.MovimentoProduto;

import com.gestao.back.model.entities.Produto;
import com.gestao.back.model.enums.TipoMovimento;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;

public class MovimentoEstoqueRequestDTO {

    @NotBlank(message = "Tipo de movimento é obrigatorio")
    @Enumerated(EnumType.STRING)
    private TipoMovimento tipo;

    @NotBlank(message = "Quantidade é obrigatorio")
    private int quantidade;

    @NotBlank(message = "Motivo é obrigatorio")
    private String motivo;

    @NotBlank(message = "Produto é obrigatorio")
    private Produto produto;

    @NotBlank(message = "Usuario precisa ser informado")
    private Long  usuarioId;

    public MovimentoEstoqueRequestDTO() {
    }

    public TipoMovimento getTipo() {
        return tipo;
    }

    public void setTipo(TipoMovimento tipo) {
        this.tipo = this.tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
