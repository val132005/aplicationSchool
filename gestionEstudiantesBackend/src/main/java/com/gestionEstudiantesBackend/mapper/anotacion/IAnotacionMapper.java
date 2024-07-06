package com.gestionEstudiantesBackend.mapper.anotacion;

import com.gestionEstudiantesBackend.mapper.IMapperGenerico;
import com.gestionEstudiantesBackend.model.anotacion.Anotacion;
import com.gestionEstudiantesBackend.model.anotacion.AnotacionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IAnotacionMapper extends IMapperGenerico<Anotacion, AnotacionDTO> {
    @Override
    @Mapping(target = "id", ignore = true)
    Anotacion loadEntity(AnotacionDTO dto);

    @Override
    AnotacionDTO loadDto(Anotacion entity);

    @Override
    List<Anotacion> loadEntities(List<AnotacionDTO> dtos);

    @Override
    List<AnotacionDTO> loadDtos(List<Anotacion> entities);

}
