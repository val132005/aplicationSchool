package com.gestionEstudiantesBackend.repository.anotacion;

import com.gestionEstudiantesBackend.model.anotacion.Anotacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnotacionRepository extends JpaRepository<Anotacion, Long> {
}
