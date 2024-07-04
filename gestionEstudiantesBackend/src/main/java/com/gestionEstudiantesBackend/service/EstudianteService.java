package com.gestionEstudiantesBackend.service;

import com.gestionEstudiantesBackend.exception.ResourceNotFoundException;
import com.gestionEstudiantesBackend.model.estudiante.Estado;
import com.gestionEstudiantesBackend.model.estudiante.Estudiante;
import com.gestionEstudiantesBackend.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    public List<Estudiante> listarEstudiantes() {
        return estudianteRepository.findAll();
    }

    public Estudiante registrarEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    public Estudiante consultarEstudiante(long id) {
        return estudianteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El estudiante con Id " + id + " no existe"));
    }

    public Estudiante actualizarEstudiante(long id, Estudiante estudianteRequest) {
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El estudiante con Id " + id + " no existe"));
        estudiante.setEstado(estudianteRequest.getEstado());
        estudiante.setNombre(estudianteRequest.getNombre());
        estudiante.setTipoDocumento(estudianteRequest.getTipoDocumento());
        estudiante.setNumeroDeDocumento(estudianteRequest.getNumeroDeDocumento());
        estudiante.setGenero(estudianteRequest.getGenero());
        estudiante.setEdad(estudianteRequest.getEdad());
        estudiante.setFechaDeNacimiento(estudianteRequest.getFechaDeNacimiento());
        estudiante.setCiudadDeNacimiento(estudianteRequest.getCiudadDeNacimiento());
        estudiante.setPaisDeNacimiento(estudianteRequest.getPaisDeNacimiento());
        estudiante.setNivelAcademico(estudianteRequest.getNivelAcademico());
        estudiante.setCursoAlQuePertenece(estudianteRequest.getCursoAlQuePertenece());
        estudiante.setNumeroDeTelefono(estudianteRequest.getNumeroDeTelefono());
        estudiante.setEmail(estudianteRequest.getEmail());
        estudiante.setDireccion(estudianteRequest.getDireccion());
        estudiante.setNombreDelAcudiente(estudianteRequest.getNombreDelAcudiente());
        estudiante.setRelacionEntreElAcudienteYEstudiante(estudianteRequest.getRelacionEntreElAcudienteYEstudiante());
        estudiante.setTelefonoDelAcudiente(estudianteRequest.getTelefonoDelAcudiente());
        estudiante.setEmailDelAcudiente(estudianteRequest.getEmailDelAcudiente());

        return estudianteRepository.save(estudiante);
    }

    public Estudiante inactivarEstudiante(long id) {
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El estudiante con Id " + id + " no existe"));
        estudiante.setEstado(Estado.INACTIVO);
        return estudianteRepository.save(estudiante);
    }

    public Estudiante activarEstudiante(long id) {
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El estudiante con Id " + id + " no existe"));
        estudiante.setEstado(Estado.ACTIVO);
        return estudianteRepository.save(estudiante);
    }

}
