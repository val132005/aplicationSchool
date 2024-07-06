package com.gestionEstudiantesBackend.model.curso;

import com.gestionEstudiantesBackend.model.estudiante.EstudianteDTO;
import com.gestionEstudiantesBackend.model.profesor.ProfesorDTO;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CursoDTO {
    @NotNull
    private int curso;
    @NotNull
    private String estado;
    @NotNull
    private ProfesorDTO profesorDTO;

    @NotNull
    private List<EstudianteDTO> estudiantesDTOS;
}
