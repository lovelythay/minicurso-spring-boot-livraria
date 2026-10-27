package br.edu.ifsp.pep.exercicioLivraria.service;

import br.edu.ifsp.pep.exercicioLivraria.dto.LivroRequestDTO;
import br.edu.ifsp.pep.exercicioLivraria.dto.LivroResponseDTO;
import br.edu.ifsp.pep.exercicioLivraria.model.Livro;
import br.edu.ifsp.pep.exercicioLivraria.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;

    public List<LivroResponseDTO> obterLivros(){

        List<Livro> livrosList = this.livroRepository.findAll();

        return livrosList.stream().map(LivroResponseDTO::new).toList();
    }

    public Optional<LivroResponseDTO> obterLivroPorId(Long id){ // optional - pode ou não retornar valor, o compilador nos obriga a tratar e evita exceções inesperadas

        return this.livroRepository.findById(id).map(LivroResponseDTO::new); // se houver resposta, mapeia a entidade para o DTO
    }

    public LivroResponseDTO cadastrarLivro(LivroRequestDTO livroRequestDTO){

        Livro livro = new Livro();

        livro.setTitulo(livroRequestDTO.titulo());
        livro.setAutor(livroRequestDTO.autor());
        livro.setQuantidade(livroRequestDTO.quantidade());
        livro.setPreco(livroRequestDTO.preco());

        return new LivroResponseDTO(this.livroRepository.save(livro));
    }

    public Optional<LivroResponseDTO> alterarLivro(LivroRequestDTO livroRequestDTO, Long id){

        return this.livroRepository.findById(id).map(livro -> {
               livro.setTitulo(livroRequestDTO.titulo());
               livro.setAutor(livroRequestDTO.autor());
               livro.setPreco(livroRequestDTO.preco());
               livro.setQuantidade(livroRequestDTO.quantidade());

               return new LivroResponseDTO(this.livroRepository.save(livro));
        });
    }

    public boolean removerLivro(Long id){

        if  (!this.livroRepository.existsById(id)){

            return false;
        }

        this.livroRepository.deleteById(id);
        return true;
    }

}
