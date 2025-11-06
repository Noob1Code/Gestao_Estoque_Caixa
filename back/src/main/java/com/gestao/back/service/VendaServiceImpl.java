/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestao.back.service;

import com.gestao.back.dto.ItemVendaRequestDTO;
import com.gestao.back.dto.VendaRequestDTO;
import com.gestao.back.dto.VendaResponseDTO;
import com.gestao.back.model.entities.ItemVenda;
import com.gestao.back.model.entities.MovimentoEstoque;
import com.gestao.back.model.entities.Produto;
import com.gestao.back.model.entities.Usuario;
import com.gestao.back.model.entities.Venda;
import com.gestao.back.model.enums.TipoMovimento;
import com.gestao.back.model.repositories.MovimentoEstoqueRepository;
import com.gestao.back.model.repositories.ProdutoRepository;
import com.gestao.back.model.repositories.UsuarioRepository;
import com.gestao.back.model.repositories.VendaRepository;
import jakarta.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Kayqu
 */

@Service
public class VendaServiceImpl {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository; 

    @Autowired
    private MovimentoEstoqueRepository movimentoEstoqueRepository; 

    @Transactional
    public VendaResponseDTO registrarVenda(VendaRequestDTO dto) {
        
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new EntityNotFoundException("Usuário (Operador) não encontrado"));

        BigDecimal troco = dto.getValorRecebido().subtract(dto.getTotal());
        if (troco.compareTo(BigDecimal.ZERO) < 0) {
             throw new IllegalArgumentException("Valor recebido é menor que o total da venda.");
        }

        Venda venda = new Venda();
        venda.setUsuario(usuario);
        venda.setDataVenda(LocalDateTime.now());
        venda.setTotal(dto.getTotal());
        venda.setValorRecebido(dto.getValorRecebido());
        venda.setTroco(troco);

       Set<ItemVenda> itensParaSalvar = new HashSet<>();
        
        for (ItemVendaRequestDTO itemDto : dto.getItens()) {
            
            Produto produto = produtoRepository.findById(itemDto.getProdutoId())
                    .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado: ID " + itemDto.getProdutoId()));

            if (produto.getQuantidadeEstoque() < itemDto.getQuantidade()) {
                throw new RuntimeException("Estoque insuficiente para o produto: " + produto.getNome());
            }

            int novoEstoque = produto.getQuantidadeEstoque() - itemDto.getQuantidade();
            produto.setQuantidadeEstoque(novoEstoque);
            produtoRepository.save(produto); 

            ItemVenda itemVenda = new ItemVenda();
            itemVenda.setProduto(produto);
            itemVenda.setQuantidade(itemDto.getQuantidade());
            itemVenda.setPrecoUnitario(itemDto.getPrecoUnitario());
            
            venda.adicionarItem(itemVenda);
        }
        Venda vendaSalva = vendaRepository.save(venda);
        for (ItemVenda itemSalvo : vendaSalva.getItens()) {
            MovimentoEstoque movimento = new MovimentoEstoque();
            movimento.setProduto(itemSalvo.getProduto());
            movimento.setUsuario(usuario);
            movimento.setTipo(TipoMovimento.SAIDA_VENDA);
            movimento.setQuantidade(itemSalvo.getQuantidade() * -1);
            movimento.setData(vendaSalva.getDataVenda()); 
            movimento.setMotivo("Venda ID: " + vendaSalva.getId()); 
            movimentoEstoqueRepository.save(movimento);
        }
        return new VendaResponseDTO(vendaSalva);
    }
}