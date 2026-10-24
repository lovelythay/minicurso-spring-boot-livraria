package br.edu.ifsp.pep.exercicioLivraria.controller;

import br.edu.ifsp.pep.exercicioLivraria.dto.LivroResponseDTO;
import br.edu.ifsp.pep.exercicioLivraria.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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


}
