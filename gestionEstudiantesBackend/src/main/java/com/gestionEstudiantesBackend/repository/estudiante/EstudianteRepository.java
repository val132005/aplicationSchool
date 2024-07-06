package com.gestionEstudiantesBackend.repository.estudiante;

import com.gestionEstudiantesBackend.model.estudiante.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {


}
