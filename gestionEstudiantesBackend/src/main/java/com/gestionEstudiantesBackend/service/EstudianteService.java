package com.gestionEstudiantesBackend.service;

import com.gestionEstudiantesBackend.exception.ResourceNotFoundException;
import com.gestionEstudiantesBackend.mapper.IEstudianteMapper;
import com.gestionEstudiantesBackend.model.estudiante.*;
import com.gestionEstudiantesBackend.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private IEstudianteMapper mapper;

    public List<EstudianteDTO> listarEstudiantes() {
        return mapper.loadDtos(estudianteRepository.findAll());
    }

    public EstudianteDTO registrarEstudiante(Estudiante estudiante) {
        return mapper.loadDto(estudianteRepository.save(estudiante));
    }

    public EstudianteDTO consultarEstudiante(long id) {
        return mapper.loadDto(estudianteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El estudiante con Id " + id + " no existe")));
    }

    public EstudianteDTO actualizarEstudiante(long id, EstudianteDTO estudianteRequest) {
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El estudiante con Id " + id + " no existe"));
        estudiante.setEstado(Estado.valueOf(estudianteRequest.getEstado()));
        estudiante.setNombre(estudianteRequest.getNombre());
        estudiante.setTipoDocumento(TipoDocumento.valueOf(estudianteRequest.getTipoDocumento()));
        estudiante.setNumeroDeDocumento(estudianteRequest.getNumeroDeDocumento());
        estudiante.setGenero(Genero.valueOf(estudianteRequest.getGenero()));
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

        return mapper.loadDto(estudianteRepository.save(estudiante));
    }

    public EstudianteDTO inactivarEstudiante(long id) {
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El estudiante con Id " + id + " no existe"));
        estudiante.setEstado(Estado.INACTIVO);
        return mapper.loadDto(estudianteRepository.save(estudiante));
    }

    public EstudianteDTO activarEstudiante(long id) {
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El estudiante con Id " + id + " no existe"));
        estudiante.setEstado(Estado.ACTIVO);
        return mapper.loadDto(estudianteRepository.save(estudiante));
    }

}
