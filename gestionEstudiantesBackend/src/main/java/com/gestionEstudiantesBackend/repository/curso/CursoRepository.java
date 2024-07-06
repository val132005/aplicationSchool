package com.gestionEstudiantesBackend.repository.curso;

import com.gestionEstudiantesBackend.model.curso.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
