package com.alura.forohub.domian.respuesta.validaciones.actualizar;

import com.alura.forohub.domian.respuesta.ActualizarRespuesta;
import com.alura.forohub.domian.respuesta.Respuesta;
import com.alura.forohub.domian.respuesta.RespuestaRepository;
import com.alura.forohub.domian.topico.Estado;
import com.alura.forohub.domian.topico.TopicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;

public class SolucionDuplicada implements ValidarRespuestaActualizada{

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public void validate(ActualizarRespuesta data, Long respuestaId){
        if (data.solucion()){
            Respuesta respuesta = respuestaRepository.getReferenceById(respuestaId);
            var topicoResuelto = topicoRepository.getReferenceById(respuesta.getTopico().getId());
            if (topicoResuelto.getEstado() == Estado.CLOSED){
                throw new ValidationException("Este topico ya esta solucionado.");
            }
        }
    }
}
