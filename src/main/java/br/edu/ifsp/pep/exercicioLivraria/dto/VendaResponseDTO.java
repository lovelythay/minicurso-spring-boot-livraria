package br.edu.ifsp.pep.exercicioLivraria.dto;

import br.edu.ifsp.pep.exercicioLivraria.model.Venda;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record VendaResponseDTO(Long id, LocalDate data, BigDecimal total, List<ItemVendaDTO> itens) {

    public VendaResponseDTO(Venda venda) {
        this(venda.getId(),
                venda.getData(),
                venda.getTotal(),
                venda.getItens().stream()
                        .map(ItemVendaDTO::new)
                        .toList());
    }
}
