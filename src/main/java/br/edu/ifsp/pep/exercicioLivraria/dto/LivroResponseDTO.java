package br.edu.ifsp.pep.exercicioLivraria.dto;

import br.edu.ifsp.pep.exercicioLivraria.model.Livro;

import java.math.BigDecimal;

public record LivroResponseDTO(Long id, String titulo, String autor, Integer quantidade, BigDecimal preco) {

    public LivroResponseDTO(Livro livro) {
        this(livro.getId(), livro.getTitulo(), livro.getAutor(), livro.getQuantidade(), livro.getPreco());
    }
}
