package br.edu.ifsp.pep.exercicioLivraria.dto;

import br.edu.ifsp.pep.exercicioLivraria.model.ItemVenda;

import java.math.BigDecimal;

public record ItemVendaDTO(Long idLivro, BigDecimal precoUnitario, Integer quantidade){

    public ItemVendaDTO(ItemVenda item) {
        this(item.getLivro().getId(), item.getPrecoUnitario(), item.getQuantidade());
    }
}
