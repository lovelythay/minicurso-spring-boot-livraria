package br.edu.ifsp.pep.exercicioLivraria.service;

import br.edu.ifsp.pep.exercicioLivraria.dto.LivroRequestDTO;
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

    public LivroResponseDTO cadastrarLivro(LivroRequestDTO livroRequestDTO){

        Livro livro = new Livro();

        livro.setTitulo(livroRequestDTO.titulo());
        livro.setAutor(livroRequestDTO.autor());
        livro.setQuantidade(livroRequestDTO.quantidade());
        livro.setPreco(livroRequestDTO.preco());

        return new LivroResponseDTO(this.livroRepository.save(livro));
    }

}
