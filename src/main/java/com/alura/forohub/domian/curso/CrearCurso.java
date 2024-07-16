package com.alura.forohub.domian.curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CrearCurso(
        @NotBlank
        String name,
        @NotNull
        Categoria categoria
) {
}
