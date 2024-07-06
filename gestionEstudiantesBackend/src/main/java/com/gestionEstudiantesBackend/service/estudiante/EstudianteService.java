package com.gestionEstudiantesBackend.service.estudiante;

import com.gestionEstudiantesBackend.exception.ResourceNotFoundException;
import com.gestionEstudiantesBackend.mapper.estudiante.IEstudianteMapper;
import com.gestionEstudiantesBackend.model.Estado;
import com.gestionEstudiantesBackend.model.Genero;
import com.gestionEstudiantesBackend.model.TipoDocumento;
import com.gestionEstudiantesBackend.model.estudiante.Estudiante;
import com.gestionEstudiantesBackend.model.estudiante.EstudianteDTO;
import com.gestionEstudiantesBackend.repository.estudiante.EstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {

    private EstudianteRepository estudianteRepository;
    private IEstudianteMapper mapper;

    public EstudianteService(EstudianteRepository estudianteRepository, IEstudianteMapper mapper) {
        this.estudianteRepository = estudianteRepository;
        this.mapper = mapper;
    }

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
