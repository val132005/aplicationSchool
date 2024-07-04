package com.gestionEstudiantesBackend.mapper;

import com.gestionEstudiantesBackend.model.estudiante.Estudiante;
import com.gestionEstudiantesBackend.model.estudiante.EstudianteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IEstudianteMapper extends IMapperGenerico<Estudiante, EstudianteDTO> {

    @Override
    @Mapping(target = "id", ignore = true)
    Estudiante loadEntity(EstudianteDTO dto);

    @Override
    EstudianteDTO loadDto(Estudiante entity);

    @Override
    List<Estudiante> loadEntities(List<EstudianteDTO> dtos);

    @Override
    List<EstudianteDTO> loadDtos(List<Estudiante> entities);
}
