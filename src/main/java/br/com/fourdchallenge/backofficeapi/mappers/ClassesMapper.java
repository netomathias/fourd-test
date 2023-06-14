package br.com.fourdchallenge.backofficeapi.mappers;

import br.com.fourdchallenge.backofficeapi.dtos.classes.ClassesRequestDTO;
import br.com.fourdchallenge.backofficeapi.dtos.classes.ClassesResponseDTO;
import br.com.fourdchallenge.backofficeapi.services.impl.JwtService;
import br.com.fourdchallenge.backofficeapi.entities.classes.ClassesEntity;
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
