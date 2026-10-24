package br.edu.ifsp.pep.exercicioLivraria.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name="livro")

@Data // getter, setter, equals and hashcode, toString
@AllArgsConstructor
@NoArgsConstructor
public class Livro implements Serializable {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long id;

    @Column(name="titulo", length = 50, nullable = false)
    private String titulo;

    @Column(name="autor", length = 30, nullable = false)
    private String autor;

    @Column(name="quantidade", nullable = false)
    private Integer quantidade;
}
