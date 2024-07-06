package com.gestionEstudiantesBackend.service.curso;

import com.gestionEstudiantesBackend.exception.ResourceNotFoundException;
import com.gestionEstudiantesBackend.mapper.curso.ICursoMapper;
import com.gestionEstudiantesBackend.model.Estado;
import com.gestionEstudiantesBackend.model.curso.Curso;
import com.gestionEstudiantesBackend.model.curso.CursoDTO;
import com.gestionEstudiantesBackend.repository.curso.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    private CursoRepository cursoRepository;
    private ICursoMapper mapper;

    public CursoService(CursoRepository cursoRepository, ICursoMapper mapper){
        this.cursoRepository = cursoRepository;
        this.mapper = mapper;
    }

    public List<CursoDTO> listarCursos(){
        return mapper.loadDtos(cursoRepository.findAll());
    }

    public CursoDTO registrarCurso(Curso curso){
        return mapper.loadDto(cursoRepository.save(curso));
    }

    public CursoDTO consultarCurso(long id){
        return mapper.loadDto(cursoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El curso con Id " +id+" no existe")));
    }

    public CursoDTO actualizarCurso(long id, CursoDTO cursoRequest){
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("El curso con Id " +id+" no existe"));
        curso.setCurso(cursoRequest.getCurso());
        return mapper.loadDto(cursoRepository.save(curso));
    }

    public CursoDTO inactivarCurso(long id){
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("El curso con Id " +id+" no existe"));
        curso.setEstado(Estado.INACTIVO);
        return mapper.loadDto(cursoRepository.save(curso));
    }

    public CursoDTO activarCurso(long id){
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("El curso con Id " +id+" no existe"));
        curso.setEstado(Estado.ACTIVO);
        return mapper.loadDto(cursoRepository.save(curso));
    }





}
