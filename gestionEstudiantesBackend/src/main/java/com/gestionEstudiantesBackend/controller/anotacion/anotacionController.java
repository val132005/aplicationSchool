package com.gestionEstudiantesBackend.controller.anotacion;

import com.gestionEstudiantesBackend.model.anotacion.Anotacion;
import com.gestionEstudiantesBackend.model.anotacion.AnotacionDTO;
import com.gestionEstudiantesBackend.service.anotacion.AnotacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class anotacionController {

    private AnotacionService anotacionService;

    public anotacionController(AnotacionService anotacionService) {
        this.anotacionService = anotacionService;
    }

    @GetMapping("/listaAnotaciones")
    public List<AnotacionDTO> listarAnotaciones() {
        return anotacionService.listarAnotaciones();
    }

    @PostMapping("/registrarAnotaciones")
    public AnotacionDTO registrarAnotaciones(@RequestBody Anotacion anotacion) {
        return anotacionService.registrarAnotacion(anotacion);
    }

    @GetMapping("/consultarAnotaciones/{id}")
    public ResponseEntity<AnotacionDTO> consultarAnotaciones(@PathVariable long id) {
        AnotacionDTO anotacion = anotacionService.consultarAnotacion(id);
        return ResponseEntity.ok(anotacion);
    }

    @PutMapping("/actualizarAnotaciones/{id}")
    public ResponseEntity<AnotacionDTO> actualizarAnotaciones(@PathVariable Long id, @RequestBody AnotacionDTO anotacionRequest) {
        AnotacionDTO anotacionActualizada = anotacionService.actualizarAnotacion(id, anotacionRequest);
        return ResponseEntity.ok(anotacionActualizada);
    }



}
