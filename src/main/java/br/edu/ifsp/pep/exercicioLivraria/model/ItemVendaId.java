package br.edu.ifsp.pep.exercicioLivraria.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

@Embeddable
public class ItemVendaId {

    private Long idVenda;
    private Long idLivro;
}
