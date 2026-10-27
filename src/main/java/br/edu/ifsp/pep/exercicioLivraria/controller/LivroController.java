package br.edu.ifsp.pep.exercicioLivraria.controller;

import br.edu.ifsp.pep.exercicioLivraria.dto.LivroRequestDTO;
import br.edu.ifsp.pep.exercicioLivraria.dto.LivroResponseDTO;
import br.edu.ifsp.pep.exercicioLivraria.service.LivroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/livro")
@RequiredArgsConstructor
public class LivroController {

    private final LivroService livroService; // injeção de dependência, quem gerencia é o Spring Boot

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<LivroResponseDTO> obterLivros(){
        return this.livroService.obterLivros();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroResponseDTO> obterLivroPorId(@PathVariable Long id){ // responseEntity devolve o cabeçalho HTTP completo, com o status correto
        return this.livroService.obterLivroPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LivroResponseDTO cadastrarLivro(@RequestBody @Valid LivroRequestDTO livroRequestDTO){

        return this.livroService.cadastrarLivro(livroRequestDTO);
    }

    // metodo put - altera todos os campos do objeto
    @PutMapping("/{id}")
    public ResponseEntity<LivroResponseDTO> alterarLivro(@RequestBody @Valid LivroRequestDTO livroRequestDTO, @PathVariable Long id){

       return this.livroService.alterarLivro(livroRequestDTO,id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerLivro(@PathVariable Long id){

        if(this.livroService.removerLivro(id)){

            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

}
