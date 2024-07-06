package com.gestionEstudiantesBackend.controller.profesor;

import com.gestionEstudiantesBackend.model.profesor.Profesor;
import com.gestionEstudiantesBackend.model.profesor.ProfesorDTO;
import com.gestionEstudiantesBackend.service.profesor.ProfesorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProfesorController {

    private ProfesorService profesorService;

    public ProfesorController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }


    @GetMapping("/listaProfesores")
    public List<ProfesorDTO> listarProfesores() {
        return profesorService.listarProfesor();
    }

    @PostMapping("/registrarProfesores")
    public ProfesorDTO registrarProfesores(@RequestBody Profesor profesor) {
        return profesorService.registrarProfesor(profesor);
    }

    @GetMapping("/consultarProfesores/{id}")
    public ResponseEntity<ProfesorDTO> consultarProfesores(@PathVariable long id) {
        ProfesorDTO profesor = profesorService.consultarProfesor(id);
        return ResponseEntity.ok(profesor);
    }

    @PutMapping("/actualizarProfesores/{id}")
    public ResponseEntity<ProfesorDTO> actualizarProfesores(@PathVariable Long id, @RequestBody ProfesorDTO profesorRequest) {
        ProfesorDTO profesorActualizado = profesorService.actualizarProfesor(id, profesorRequest);
        return ResponseEntity.ok(profesorActualizado);
    }

    @PutMapping("/inactivarProfesores/{id}")
    public ResponseEntity<ProfesorDTO> inactivarProfesores(@PathVariable Long id) {
        ProfesorDTO profesorActualizado = profesorService.inactivarProfesor(id);
        return ResponseEntity.ok(profesorActualizado);
    }

    @PutMapping("/activarProfesores/{id}")
    public ResponseEntity<ProfesorDTO> activarProfesores(@PathVariable Long id) {
        ProfesorDTO profesorActualizado = profesorService.activarProfesor(id);
        return ResponseEntity.ok(profesorActualizado);
    }



}
