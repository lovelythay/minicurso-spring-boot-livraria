package br.edu.ifsp.pep.exercicioLivraria.repository;

import br.edu.ifsp.pep.exercicioLivraria.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro,Long> {
}
