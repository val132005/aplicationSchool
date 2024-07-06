package com.gestionEstudiantesBackend.model.curso;

import com.gestionEstudiantesBackend.model.Estado;
import com.gestionEstudiantesBackend.model.estudiante.Estudiante;
import com.gestionEstudiantesBackend.model.profesor.Profesor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "curso")
    private int curso;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @OneToOne
    @JoinColumn(name = "profesor_id", unique = true)
    private Profesor profesor;

    @OneToMany(mappedBy = "curso")
    private List<Estudiante> estudiantes;

}
