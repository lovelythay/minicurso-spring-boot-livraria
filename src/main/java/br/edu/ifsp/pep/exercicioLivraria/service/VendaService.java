package br.edu.ifsp.pep.exercicioLivraria.service;

import br.edu.ifsp.pep.exercicioLivraria.dto.VendaResponseDTO;
import br.edu.ifsp.pep.exercicioLivraria.model.Venda;
import br.edu.ifsp.pep.exercicioLivraria.repository.LivroRepository;
import br.edu.ifsp.pep.exercicioLivraria.repository.VendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VendaService {

    private final VendaRepository vendaRepository;
    private final LivroRepository livroRepository;

    public List<VendaResponseDTO> obterVendas(){

        List<Venda> vendas = this.vendaRepository.findAll();

        return vendas.stream().map(VendaResponseDTO::new).toList();
    }



}
