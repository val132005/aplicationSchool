package com.gestionEstudiantesBackend.controller.curso;

import com.gestionEstudiantesBackend.model.curso.Curso;
import com.gestionEstudiantesBackend.model.curso.CursoDTO;
import com.gestionEstudiantesBackend.service.curso.CursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CursoController {

    private CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }


    @GetMapping("/listaCurso")
    public List<CursoDTO> listarCursos(){
        return  cursoService.listarCursos();
    }

    @PostMapping("/registrarCursos")
    public CursoDTO registrarCursos(@RequestBody Curso curso) {
        return cursoService.registrarCurso(curso);
    }

    @GetMapping("/consultarCursos/{id}")
    public ResponseEntity<CursoDTO> consultarCursos(@PathVariable long id) {
        CursoDTO curso= cursoService.consultarCurso(id);
        return ResponseEntity.ok(curso);
    }

    @PutMapping("/actualizarCurso/{id}")
    public ResponseEntity<CursoDTO> actualizarCurso(@PathVariable Long id, @RequestBody CursoDTO cursoRequest) {
        CursoDTO cursoActualizado = cursoService.actualizarCurso(id, cursoRequest);
        return ResponseEntity.ok(cursoActualizado);
    }

    @PutMapping("/inactivarCurso/{id}")
    public ResponseEntity<CursoDTO> inactivarcurso(@PathVariable Long id) {
        CursoDTO cursoActualizado = cursoService.inactivarCurso(id);
        return ResponseEntity.ok(cursoActualizado);
    }

    @PutMapping("/activarCurso/{id}")
    public ResponseEntity<CursoDTO> activarCurso(@PathVariable Long id) {
        CursoDTO cursoActualizado = cursoService.activarCurso(id);
        return ResponseEntity.ok(cursoActualizado);
    }


}
