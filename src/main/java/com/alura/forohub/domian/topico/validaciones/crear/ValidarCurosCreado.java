package com.alura.forohub.domian.topico.validaciones.crear;

import com.alura.forohub.domian.curso.CursoRepository;
import com.alura.forohub.domian.topico.CrearTopico;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidarCurosCreado implements ValidarTopicoCreado{

    @Autowired
    private CursoRepository repository;

    @Override
    public void validate(CrearTopico data){
        var ExisteCurso = repository.existsById(data.cursoId());
        if (!ExisteCurso){
            throw new ValidationException("Este curso no existe");
        }

        var cursoHabilitado = repository.findById(data.cursoId()).get().getActivo();
        if(!cursoHabilitado){
            throw new ValidationException("Este curso no esta disponible en este momento.");
        }
    }
}
