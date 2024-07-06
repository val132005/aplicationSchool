package com.gestionEstudiantesBackend.mapper.curso;

import com.gestionEstudiantesBackend.mapper.IMapperGenerico;
import com.gestionEstudiantesBackend.model.curso.Curso;
import com.gestionEstudiantesBackend.model.curso.CursoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ICursoMapper extends IMapperGenerico<Curso, CursoDTO> {
    @Override
    @Mapping(target = "id", ignore = true)
    Curso loadEntity(CursoDTO dto);

    @Override
    CursoDTO loadDto(Curso entity);

    @Override
    List<Curso> loadEntities(List<CursoDTO> dtos);

    @Override
    List<CursoDTO> loadDtos(List<Curso> entities);

}
