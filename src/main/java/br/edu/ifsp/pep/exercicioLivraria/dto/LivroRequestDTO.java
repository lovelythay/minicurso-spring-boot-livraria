package br.edu.ifsp.pep.exercicioLivraria.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record LivroRequestDTO(
        @NotBlank(message="Informe o título")
        @Size(min=3, max = 50, message = "O título deve ter entre 3 e 50 caracteres")
        String titulo,

        @NotBlank(message="Informe o autor")
        @Size(min=3, max = 30, message = "O nome do título deve ter entre 3 e 50 caracteres")
        String autor,

        @NotNull(message="Informe a quantidade")
        @Min(value=0, message = "A quantidade mínima aceita é 0")
        Integer quantidade,

        @NotNull(message="Informe o preco")
        @Min(value=0, message = "A quantidade mínima aceita é 0.00")
        BigDecimal preco
) {}
