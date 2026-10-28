package br.edu.ifsp.pep.exercicioLivraria.controller;

import br.edu.ifsp.pep.exercicioLivraria.dto.VendaResponseDTO;
import br.edu.ifsp.pep.exercicioLivraria.service.VendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/venda")
@RequiredArgsConstructor
public class VendaController {

     private final VendaService vendaService;

     @GetMapping
     @ResponseStatus(HttpStatus.OK)
     public List<VendaResponseDTO> obterVendas(){

        return  this.vendaService.obterVendas();
     }


}
