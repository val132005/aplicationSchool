package com.gestionEstudiantesBackend.controller;

import com.gestionEstudiantesBackend.model.estudiante.Estudiante;
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
    public List<Estudiante> listarEstudiantes() {
        return estudianteService.listarEstudiantes();
    }

    @PostMapping("/registrarEstudiantes")
    public Estudiante registrarEstudiante(@RequestBody Estudiante estudiante) {
        return estudianteService.registrarEstudiante(estudiante);
    }

    @GetMapping("/consultarEstudiante/{id}")
    public ResponseEntity<Estudiante> consultarEstudiante(@PathVariable long id) {
        Estudiante estudiante = estudianteService.consultarEstudiante(id);
        return ResponseEntity.ok(estudiante);
    }

    @PutMapping("/actualizarEstudiante/{id}")
    public ResponseEntity<Estudiante> actualizarEstudiante(@PathVariable Long id, @RequestBody Estudiante estudianteRequest) {
        Estudiante estudianteActualizado = estudianteService.actualizarEstudiante(id, estudianteRequest);
        return ResponseEntity.ok(estudianteActualizado);
    }

    @PutMapping("/inactivarEstudiante/{id}")
    public ResponseEntity<Estudiante> inactivarEstudiante(@PathVariable Long id) {
        Estudiante estudianteActualizado = estudianteService.inactivarEstudiante(id);
        return ResponseEntity.ok(estudianteActualizado);
    }

    @PutMapping("/activarEstudiante/{id}")
    public ResponseEntity<Estudiante> activarEstudiante(@PathVariable Long id) {
        Estudiante estudianteActualizado = estudianteService.activarEstudiante(id);
        return ResponseEntity.ok(estudianteActualizado);
    }



}
