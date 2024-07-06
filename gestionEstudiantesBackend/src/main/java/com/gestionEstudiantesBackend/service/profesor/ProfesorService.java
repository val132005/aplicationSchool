package com.gestionEstudiantesBackend.service.profesor;

import com.gestionEstudiantesBackend.exception.ResourceNotFoundException;
import com.gestionEstudiantesBackend.mapper.profesor.IProfesorMapper;
import com.gestionEstudiantesBackend.model.Estado;
import com.gestionEstudiantesBackend.model.Genero;
import com.gestionEstudiantesBackend.model.TipoDocumento;
import com.gestionEstudiantesBackend.model.profesor.Profesor;
import com.gestionEstudiantesBackend.model.profesor.ProfesorDTO;
import com.gestionEstudiantesBackend.repository.profesor.ProfesorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorService {

    private ProfesorRepository profesorRepository;
    private IProfesorMapper mapper;

    public ProfesorService(ProfesorRepository profesorRepository, IProfesorMapper mapper) {
        this.profesorRepository = profesorRepository;
        this.mapper = mapper;
    }

    public List<ProfesorDTO> listarProfesor(){
        return mapper.loadDtos(profesorRepository.findAll());
    }

    public ProfesorDTO registrarProfesor(Profesor profesor){
        return mapper.loadDto(profesorRepository.save(profesor));
    }

    public ProfesorDTO consultarProfesor(long id){
        return mapper.loadDto(profesorRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException ("El profesor con Id " + id + " no existe")));
    }

    public ProfesorDTO actualizarProfesor(long id, ProfesorDTO profesorRequest){
        Profesor profesor = profesorRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("El profesor con Id " + id + " no existe"));

        profesor.setEstado(Estado.valueOf(profesorRequest.getEstado()));
        profesor.setNombre(profesorRequest.getNombre());
        profesor.setTipoDocumento(TipoDocumento.valueOf(profesorRequest.getTipoDocumento()));
        profesor.setNumeroDeDocumento(profesorRequest.getNumeroDeDocumento());
        profesor.setGenero(Genero.valueOf(profesorRequest.getGenero()));
        profesor.setEdad(profesorRequest.getEdad());
        profesor.setFechaDeNacimiento(profesorRequest.getFechaDeNacimiento());
        profesor.setCiudadDeNacimiento(profesorRequest.getCiudadDeNacimiento());
        profesor.setPaisDeNacimiento(profesorRequest.getPaisDeNacimiento());
        profesor.setNumeroDeTelefono(profesorRequest.getNumeroDeTelefono());
        profesor.setEmail(profesorRequest.getEmail());
        profesor.setDireccion(profesorRequest.getDireccion());
        return mapper.loadDto(profesorRepository.save(profesor));

    }

    public ProfesorDTO inactivarProfesor(long id) {
        Profesor profesor = profesorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El profesor con Id " + id + " no existe"));

        profesor.setEstado(Estado.INACTIVO);
        return mapper.loadDto(profesorRepository.save(profesor));
    }

    public ProfesorDTO activarProfesor(long id) {
        Profesor profesor = profesorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El profesor con Id " + id + " no existe"));

        profesor.setEstado(Estado.ACTIVO);
        return mapper.loadDto(profesorRepository.save(profesor));
    }


}
