package com.alura.forohub.domian.topico.validaciones.crear;

import com.alura.forohub.domian.topico.CrearTopico;
import com.alura.forohub.domian.usuario.UsuarioRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidarTopicoUsuario implements ValidarTopicoCreado{

    @Autowired
    private UsuarioRepository repository;

    @Override
    public void validate(CrearTopico data){
        var existeUsuario = repository.existsById(data.usuarioId());
        if (!existeUsuario){
            throw new  ValidationException("Este usuario no existe");
        }

        var usuarioHabilitado = repository.findById(data.usuarioId()).get().getEnabled();
        if (!usuarioHabilitado){
            throw new ValidationException("Este usuario fue habilitado.");
        }
    }
}
