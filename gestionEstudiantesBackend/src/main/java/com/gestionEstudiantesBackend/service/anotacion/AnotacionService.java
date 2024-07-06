package com.gestionEstudiantesBackend.service.anotacion;

import com.gestionEstudiantesBackend.exception.ResourceNotFoundException;
import com.gestionEstudiantesBackend.mapper.anotacion.IAnotacionMapper;
import com.gestionEstudiantesBackend.model.anotacion.Anotacion;
import com.gestionEstudiantesBackend.model.anotacion.AnotacionDTO;
import com.gestionEstudiantesBackend.repository.anotacion.AnotacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnotacionService {

    private AnotacionRepository anotacionRepository;
    private IAnotacionMapper mapper;

    public AnotacionService(AnotacionRepository anotacionRepository, IAnotacionMapper mapper) {
        this.anotacionRepository = anotacionRepository;
        this.mapper = mapper;
    }

    public List<AnotacionDTO> listarAnotaciones(){
        return mapper.loadDtos(anotacionRepository.findAll());
    }

    public AnotacionDTO registrarAnotacion(Anotacion anotacion){
        return  mapper.loadDto(anotacionRepository.save(anotacion));
    }

    public AnotacionDTO consultarAnotacion(long id){
        return mapper.loadDto(anotacionRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("La anotacion con Id " + id + " no existe")));
    }

    public  AnotacionDTO actualizarAnotacion(long id, AnotacionDTO anotacionRequest){
        Anotacion anotacion = anotacionRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("La anotacion con Id " + id + " no existe"));
        anotacion.setFecha(anotacionRequest.getFecha());
        anotacion.setHora(anotacionRequest.getHora());
        anotacion.setLlamadoDeAtencion(anotacionRequest.getLlamadoDeAtencion());

        return mapper.loadDto(anotacionRepository.save(anotacion));
    }





}
