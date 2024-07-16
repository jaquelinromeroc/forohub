package com.alura.forohub.domian.curso;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cursos")
@Entity(name = "Curso")
@EqualsAndHashCode(of = "id")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    private Boolean activo;

    public Curso(CrearCurso crearCurso){
        this.name = crearCurso.name();
        this.categoria = crearCurso.categoria();
        this.activo = true;
    }

    public void actualizarCurso(ActualizarCurso actualizarCurso){
        if(actualizarCurso.name() != null){
            this.name = actualizarCurso.name();
        }
        if(actualizarCurso.categoria() != null){
            this.categoria = actualizarCurso.categoria();
        }
        if (actualizarCurso.activo() != null){
            this.activo = actualizarCurso.activo();
        }
    }

    public void eliminarCurso(){
        this.activo = false;
    }

}
