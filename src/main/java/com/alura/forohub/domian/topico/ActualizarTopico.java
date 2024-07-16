package com.alura.forohub.domian.topico;


public record ActualizarTopico(
        String titulo,
        String mensaje,
        Estado estado,
        Long cursoId
) {
}
