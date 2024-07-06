package com.gestionEstudiantesBackend.repository.profesor;

import com.gestionEstudiantesBackend.model.profesor.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
}
