package br.edu.ifsp.pep.exercicioLivraria.dto;

import java.time.LocalDate;
import java.util.List;

public record VendaRequestDTO(LocalDate data, List<ItemVendaDTO> itens){}
