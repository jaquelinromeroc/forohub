package com.alura.forohub.domian.topico;

import com.alura.forohub.domian.curso.Curso;
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
@Table(name = "topicos")
@Entity(name = "Topico")
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;

    @Column(name= "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "ultima-actualizacion")
    private LocalDateTime ultimaActualizacion;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;


    public Topico(CrearTopico crearTopico, Usuario usuario, Curso curso){
        this.titulo = crearTopico.titulo();
        this.mensaje = crearTopico.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.ultimaActualizacion = LocalDateTime.now();
        this.estado = Estado.OPEN;
        this.usuario = usuario;
        this.curso = curso;
    }


    public void actualizarTopicoConCurso(ActualizarTopico actualizacionTopico, Curso curso){
        if (actualizacionTopico.titulo() != null){
            this.titulo = actualizacionTopico.titulo();
        }

        if (actualizacionTopico.mensaje() != null){
            this.mensaje = actualizacionTopico.mensaje();
        }

        if (actualizacionTopico.estado() != null){
            this.curso = curso;
        }

        this.ultimaActualizacion = LocalDateTime.now();

    }

    public void actulizarTopico(ActualizarTopico actualizacionTopico){
        if (actualizacionTopico.titulo() != null){
            this.titulo = actualizacionTopico.titulo();
        }

        if (actualizacionTopico.mensaje() != null){
            this.mensaje = actualizacionTopico.mensaje();
        }

        if (actualizacionTopico.estado() != null){
            this.estado =actualizacionTopico.estado();
        }

        this.ultimaActualizacion = LocalDateTime.now();
    }

    public void eliminarTopico(){
        this.estado = Estado.DELETED;
    }

    public void setEstado(Estado estado){
        this.estado = estado;
    }
}


