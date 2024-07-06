package com.gestionEstudiantesBackend.model.anotacion;

import com.gestionEstudiantesBackend.model.curso.Curso;
import com.gestionEstudiantesBackend.model.estudiante.Estudiante;
import com.gestionEstudiantesBackend.model.profesor.Profesor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Anotaciones")
public class Anotacion {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Fecha")
    private Date fecha;

    @Column(name = "hora")
    private Time hora;

    @Column(name = "llamadoDeAtencion")
    private String llamadoDeAtencion;

    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;


}
