package com.alura.forohub.domian.usuario;

public record ActualizarUsuario(
        String password,
        Role role,
        String nombre,
        String apellido,
        String email,
        Boolean enabled
) {
}
