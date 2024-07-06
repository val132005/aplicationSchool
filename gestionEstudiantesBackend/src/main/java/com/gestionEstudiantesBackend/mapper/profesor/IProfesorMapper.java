package com.gestionEstudiantesBackend.mapper.profesor;

import com.gestionEstudiantesBackend.mapper.IMapperGenerico;
import com.gestionEstudiantesBackend.model.profesor.Profesor;
import com.gestionEstudiantesBackend.model.profesor.ProfesorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IProfesorMapper extends IMapperGenerico<Profesor, ProfesorDTO> {

    @Override
    @Mapping(target = "id", ignore = true)
    Profesor loadEntity(ProfesorDTO dto);

    @Override
    ProfesorDTO loadDto(Profesor entity);

    @Override
    List<Profesor> loadEntities(List<ProfesorDTO> dtos);

    @Override
    List<ProfesorDTO> loadDtos(List<Profesor> entities);

}
