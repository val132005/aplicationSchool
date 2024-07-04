package com.gestionEstudiantesBackend.mapper;

import java.util.List;

public interface IMapperGenerico <E, D> {

    E loadEntity(D dto);
    D loadDto(E entity);

    List<E> loadEntities(List<D> dtos);
    List<D> loadDtos(List<E> entities);

}
