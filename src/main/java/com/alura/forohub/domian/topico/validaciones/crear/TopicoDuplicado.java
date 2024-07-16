package com.alura.forohub.domian.topico.validaciones.crear;

import com.alura.forohub.domian.topico.CrearTopico;
import com.alura.forohub.domian.topico.TopicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicoDuplicado implements ValidarTopicoCreado{

    @Autowired
    private TopicoRepository topicoRepository;


    @Override
    public void validate(CrearTopico data){
        var topicoDuplicado = topicoRepository.existsByTituloAndMensaje(data.titulo(), data.mensaje());
        if(topicoDuplicado){
            throw new ValidationException("Este topico ya existe. Revise /topicos/" + topicoRepository.findByTitulo(data.titulo()).getId());
        }
    }

}
