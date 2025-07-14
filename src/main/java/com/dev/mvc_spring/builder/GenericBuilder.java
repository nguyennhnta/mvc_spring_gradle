package com.dev.mvc_spring.builder;

import org.modelmapper.ModelMapper;
import com.dev.mvc_spring.config.MapperConfig;
import java.util.Optional;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;

@Component
//@AllArgsConstructor
public class GenericBuilder {
    private final ModelMapper modelMapper;

    public GenericBuilder(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    // Dto → Entity
    public <E, D> E toEntity(D dto, Class<E> entityClass) {
        return modelMapper.map(dto, entityClass);
    }

    // Entity → Dto
    public <E, D> Optional<D> toDto(E entity, Class<D> dtoClass) {
        if (entity == null) return Optional.empty();
        return Optional.of(modelMapper.map(entity, dtoClass));
    }

    // Update entity từ dto (ghi đè field)
    public <E, D> void updateEntity(D dto, E entity) {
        modelMapper.map(dto, entity);
    }

}
