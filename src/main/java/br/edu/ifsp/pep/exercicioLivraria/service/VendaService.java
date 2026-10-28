package br.edu.ifsp.pep.exercicioLivraria.service;

import br.edu.ifsp.pep.exercicioLivraria.dto.VendaRequestDTO;
import br.edu.ifsp.pep.exercicioLivraria.dto.VendaResponseDTO;
import br.edu.ifsp.pep.exercicioLivraria.model.ItemVenda;
import br.edu.ifsp.pep.exercicioLivraria.model.Livro;
import br.edu.ifsp.pep.exercicioLivraria.model.Venda;
import br.edu.ifsp.pep.exercicioLivraria.repository.LivroRepository;
import br.edu.ifsp.pep.exercicioLivraria.repository.VendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VendaService {

    private final VendaRepository vendaRepository;
    private final LivroRepository livroRepository;

    public List<VendaResponseDTO> obterVendas(){

        List<Venda> vendas = this.vendaRepository.findAll();

        return vendas.stream().map(VendaResponseDTO::new).toList();
    }

    public Optional<VendaResponseDTO> cadastrarVenda(VendaRequestDTO vendaRequestDTO){

        boolean existeTodosLivros = vendaRequestDTO.itens().stream().allMatch(item -> this.livroRepository.existsById(item.idLivro()));
        boolean quantidadeLivros;

        if(!existeTodosLivros){
            return Optional.empty();
        }

        quantidadeLivros = vendaRequestDTO.itens().stream()
                .allMatch(item -> livroRepository.findById(item.idLivro())
                        .map(livro -> livro.getQuantidade() >= item.quantidade())
                        .orElse(false));

        if (!quantidadeLivros){
            return Optional.empty();
        }

        Venda venda = new Venda();
        BigDecimal total = BigDecimal.ZERO;

        venda.setData(vendaRequestDTO.data());

        venda.setData(vendaRequestDTO.data());

        List<ItemVenda> itens = new ArrayList<>();

        for (var itemDTO : vendaRequestDTO.itens()) {

            Livro livro = this.livroRepository.findById(itemDTO.idLivro()).get();

            livro.setQuantidade(livro.getQuantidade() - itemDTO.quantidade());
            this.livroRepository.save(livro);

            ItemVenda itemVenda = new ItemVenda();

            itemVenda.setLivro(livro);
            itemVenda.setVenda(venda);
            itemVenda.setPrecoUnitario(itemDTO.precoUnitario());
            itemVenda.setQuantidade(itemDTO.quantidade());

            BigDecimal subtotal = itemDTO.precoUnitario()
                    .multiply(BigDecimal.valueOf(itemDTO.quantidade()));

            total = total.add(subtotal);

            itens.add(itemVenda);
        }

        venda.setTotal(total);

        venda.setItens(itens);
        venda.setTotal(total);

        return Optional.of(new VendaResponseDTO(this.vendaRepository.save(venda)));
    }




}
