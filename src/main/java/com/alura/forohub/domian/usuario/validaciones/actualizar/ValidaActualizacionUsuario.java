package com.alura.forohub.domian.usuario.validaciones.actualizar;

import com.alura.forohub.domian.usuario.ActualizarUsuario;
import com.alura.forohub.domian.usuario.UsuarioRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidaActualizacionUsuario implements ValidarActualizarUsuario {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public void validate(ActualizarUsuario data){
        if(data.email() != null){
            var emailDuplicado = repository.findByEmail(data.email());
            if (emailDuplicado != null){
                throw new ValidationException("Este email ya esta en eso");
            }
        }
    }
}
