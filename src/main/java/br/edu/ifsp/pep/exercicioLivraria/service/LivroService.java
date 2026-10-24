package br.edu.ifsp.pep.exercicioLivraria.service;

import br.edu.ifsp.pep.exercicioLivraria.dto.LivroResponseDTO;
import br.edu.ifsp.pep.exercicioLivraria.model.Livro;
import br.edu.ifsp.pep.exercicioLivraria.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;

    public List<LivroResponseDTO> obterLivros(){

        List<Livro> livrosList = this.livroRepository.findAll();

        return livrosList.stream().map(LivroResponseDTO::new).toList();
    }


}
