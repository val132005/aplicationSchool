package com.gestionEstudiantesBackend.controller;

import com.gestionEstudiantesBackend.model.estudiante.Estudiante;
import com.gestionEstudiantesBackend.model.estudiante.EstudianteDTO;
import com.gestionEstudiantesBackend.service.EstudianteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EstudianteController {


    private EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping("/listaEstudiantes")
    public List<EstudianteDTO> listarEstudiantes() {
        return estudianteService.listarEstudiantes();
    }

    @PostMapping("/registrarEstudiantes")
    public EstudianteDTO registrarEstudiante(@RequestBody Estudiante estudiante) {
        return estudianteService.registrarEstudiante(estudiante);
    }

    @GetMapping("/consultarEstudiante/{id}")
    public ResponseEntity<EstudianteDTO> consultarEstudiante(@PathVariable long id) {
        EstudianteDTO estudiante = estudianteService.consultarEstudiante(id);
        return ResponseEntity.ok(estudiante);
    }

    @PutMapping("/actualizarEstudiante/{id}")
    public ResponseEntity<EstudianteDTO> actualizarEstudiante(@PathVariable Long id, @RequestBody EstudianteDTO estudianteRequest) {
        EstudianteDTO estudianteActualizado = estudianteService.actualizarEstudiante(id, estudianteRequest);
        return ResponseEntity.ok(estudianteActualizado);
    }

    @PutMapping("/inactivarEstudiante/{id}")
    public ResponseEntity<EstudianteDTO> inactivarEstudiante(@PathVariable Long id) {
        EstudianteDTO estudianteActualizado = estudianteService.inactivarEstudiante(id);
        return ResponseEntity.ok(estudianteActualizado);
    }

    @PutMapping("/activarEstudiante/{id}")
    public ResponseEntity<EstudianteDTO> activarEstudiante(@PathVariable Long id) {
        EstudianteDTO estudianteActualizado = estudianteService.activarEstudiante(id);
        return ResponseEntity.ok(estudianteActualizado);
    }



}
