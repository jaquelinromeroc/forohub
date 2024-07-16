package com.alura.forohub.domian.respuesta;

import com.alura.forohub.domian.topico.Topico;
import com.alura.forohub.domian.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "respuestas")
@Entity(name = "Respuesta")
@EqualsAndHashCode(of = "id")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;

    @Column(name="fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name="ultima_actualizacion")
    private LocalDateTime ultimaActualizacion;

    private Boolean solucion;
    private Boolean borrado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="topico_id")
    private Topico topico;

    public Respuesta(CrearRespuesta crearRespuesta, Usuario usuario, Topico topico){
        this.mensaje = crearRespuesta.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.ultimaActualizacion = LocalDateTime.now();
        this.solucion = false;
        this.borrado = false;
        this.usuario = usuario;
        this.topico = topico;
    }

    public void actualizarRespuesta(ActualizarRespuesta actualizarRespuesta){
        if (actualizarRespuesta.mensaje() != null){
            this.mensaje = actualizarRespuesta.mensaje();
        }
        if (actualizarRespuesta.solucion() != null){
            this.solucion = actualizarRespuesta.solucion();
        }
        this.ultimaActualizacion = LocalDateTime.now();
    }
    public void eliminarRespuesta(){
        this.borrado = true;
    }

}
