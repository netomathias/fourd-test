package br.com.registerpoc.registerapipoc.mappers;

import br.com.registerpoc.registerapipoc.dtos.classes.ClassesRequestDTO;
import br.com.registerpoc.registerapipoc.dtos.classes.ClassesResponseDTO;
import br.com.registerpoc.registerapipoc.entities.classes.ClassesEntity;
import br.com.registerpoc.registerapipoc.services.impl.JwtService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClassesMapper {

    private final ModelMapper modelMapper;
    private final JwtService jwtService;

    public ClassesEntity DTOToEntity(ClassesRequestDTO classesRequestDTO, String token) {
        ClassesEntity classesEntity = modelMapper.map(classesRequestDTO, ClassesEntity.class);
        classesEntity.setUserEmail(jwtService.extractTheUserEmail(token));
        return classesEntity;
    }

    public ClassesResponseDTO EntityToDTO(ClassesEntity classesEntity) {
        return modelMapper.map(classesEntity, ClassesResponseDTO.class);
    }
}
