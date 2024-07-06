package com.gestionEstudiantesBackend.model.anotacion;

import com.gestionEstudiantesBackend.model.curso.CursoDTO;
import com.gestionEstudiantesBackend.model.estudiante.EstudianteDTO;
import com.gestionEstudiantesBackend.model.profesor.ProfesorDTO;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnotacionDTO {

    @NotNull
    private Date fecha;

    @NotNull
    private Time hora;

    @NotNull
    private String llamadoDeAtencion;

    @NotNull
    private ProfesorDTO profesorDTO;

    @NotNull
    private EstudianteDTO estudianteDTO;

    @NotNull
    private CursoDTO cursoDTO;

}
