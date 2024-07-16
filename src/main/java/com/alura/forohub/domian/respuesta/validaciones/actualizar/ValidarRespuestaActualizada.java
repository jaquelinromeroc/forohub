package com.alura.forohub.domian.respuesta.validaciones.actualizar;

import com.alura.forohub.domian.respuesta.ActualizarRespuesta;


public interface ValidarRespuestaActualizada {

    public void validate(ActualizarRespuesta data, Long respuestaId);
}
