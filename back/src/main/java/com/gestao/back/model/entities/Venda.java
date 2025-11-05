package com.gestao.back.model.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "Vendas")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Preço é obrigatorio")
    @Positive(message = "Quantidade deve ser maior que 0")
    @Column(nullable = false)
    private BigDecimal valorTotal;

    @NotBlank(message = "Preço é obrigatorio")
    @Positive(message = "Quantidade deve ser maior que 0")
    @Column(nullable = false)
    private BigDecimal valorRecebido;

    @NotBlank(message = "Preço é obrigatorio")
    @Positive(message = "Quantidade deve ser maior que 0")
    @Column(nullable = false)
    private BigDecimal troco;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column(nullable = false)
    private LocalDateTime data;

    @NotBlank(message = "Itens é obrigatorio")
    private List<ItemVenda> itens;

    public Venda(long id, BigDecimal valorTotal, BigDecimal valorRecebido, BigDecimal troco, Usuario usuario, LocalDateTime data, List<ItemVenda> itens) {
        this.id = id;
        this.valorTotal = valorTotal;
        this.valorRecebido = valorRecebido;
        this.troco = troco;
        this.usuario = usuario;
        this.data = data;
        this.itens = itens;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BigDecimal getValorRecebido() {
        return valorRecebido;
    }

    public void setValorRecebido(BigDecimal valorRecebido) {
        this.valorRecebido = valorRecebido;
    }

    public BigDecimal getTroco() {
        return troco;
    }

    public void setTroco(BigDecimal troco) {
        this.troco = troco;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }
}
