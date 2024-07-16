package com.alura.forohub.domian.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CrearUsuario(
        @NotBlank
        String username,
        @NotBlank
        String password,
        @NotBlank
        String nombre,
        @NotBlank
        String apellido,
        @NotBlank
        @Email
        String email
) {
}
