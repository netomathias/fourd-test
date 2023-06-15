package br.com.fourdchallenge.backofficeapi.facades.impl;

import br.com.fourdchallenge.backofficeapi.dtos.classes.ClassesRequestDTO;
import br.com.fourdchallenge.backofficeapi.dtos.classes.ClassesResponseDTO;
import br.com.fourdchallenge.backofficeapi.services.impl.JwtService;
import br.com.fourdchallenge.backofficeapi.facades.ClassesFacade;
import br.com.fourdchallenge.backofficeapi.mappers.ClassesMapper;
import br.com.fourdchallenge.backofficeapi.services.ClassesService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ClassesFacadeImpl implements ClassesFacade {

    private final ClassesService classesService;
    private final ClassesMapper classesMapper;
    private final JwtService jwtService;


    @Override
    public ClassesResponseDTO save(ClassesRequestDTO classesRequestDTO, HttpServletRequest request) {
        return classesMapper.EntityToDTO(classesService.save(classesMapper.DTOToEntity(classesRequestDTO, request.getHeader("Authorization").substring(7))));
    }

    @Override
    public List<ClassesResponseDTO> getAllByEmail(HttpServletRequest request) {
        String email = jwtService.extractTheUserEmail(request.getHeader("Authorization").substring(7));
        return classesService.getAllByUsername(email).stream().map(classesMapper::EntityToDTO).toList();
    }
}
