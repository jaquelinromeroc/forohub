package com.alura.forohub.domian.respuesta.validaciones.crear;

import com.alura.forohub.domian.respuesta.CrearRespuesta;
import com.alura.forohub.domian.topico.Estado;
import com.alura.forohub.domian.topico.TopicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RespuestaTopicoValida implements ValidarRespuestaCreada{

    @Autowired
    private TopicoRepository repository;

    @Override
    public void validate(CrearRespuesta data){
        var topicoExiste = repository.existsById(data.topicoId());

        if(!topicoExiste){
            throw new ValidationException("Este topico no existe");
        }

        var topicoAbierto = repository.findById(data.topicoId()).get().getEstado();

        if(topicoAbierto != Estado.OPEN){
            throw new ValidationException("Este topico no esta abierto.");
        }
    }

}
