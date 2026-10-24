package br.edu.ifsp.pep.exercicioLivraria.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name="item_venda")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemVenda implements Serializable {

    @EmbeddedId
    private ItemVendaId id;

    @ManyToOne(fetch = FetchType.EAGER) // busca os itens de venda assim que a venda for consultada
    @MapsId("idVenda")
    @JoinColumn(name="idvenda")
    private Venda venda;

    @ManyToOne(fetch = FetchType.LAZY)// somente quando for solicitado
    @MapsId("idLivro")
    @JoinColumn(name="idlivro")
    private Livro livro;

    @Column(name="preco_unitario", precision = 10, scale = 2, nullable = false)
    private BigDecimal precoUnitario;

    @Column(name="quantidade", nullable = false)
    private Integer quantidade;
}
