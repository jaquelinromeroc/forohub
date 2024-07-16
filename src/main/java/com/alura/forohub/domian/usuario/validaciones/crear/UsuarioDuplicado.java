package com.alura.forohub.domian.usuario.validaciones.crear;

import com.alura.forohub.domian.usuario.CrearUsuario;
import com.alura.forohub.domian.usuario.UsuarioRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioDuplicado implements ValidarCrearUsuario{

    @Autowired
    private UsuarioRepository repository;

    @Override
    public void validate(CrearUsuario data){
        var usuarioDuplicado = repository.findByUsername(data.username());
        if (usuarioDuplicado != null){
            throw new ValidationException("Este usuario ya existe");
        }

        var emailDuplicado = repository.findByEmail(data.email());
        if (emailDuplicado != null){
            throw new ValidationException("Este email ya existe");
        }
    }
}
