package br.edu.ifsp.pep.exercicioLivraria.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="venda")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Venda implements Serializable {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long id;

    @Column(name="data", nullable = false)
    private LocalDate data;

    @Column(name="total", precision = 10, scale = 2, nullable = false)
    private Double  total;

    @OneToMany(mappedBy = "venda")
    private List<ItemVenda> itens = new ArrayList<>();
}
