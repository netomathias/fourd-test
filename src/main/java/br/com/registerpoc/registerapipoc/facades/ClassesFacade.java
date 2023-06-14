package br.com.registerpoc.registerapipoc.facades;

import br.com.registerpoc.registerapipoc.dtos.classes.ClassesRequestDTO;
import br.com.registerpoc.registerapipoc.dtos.classes.ClassesResponseDTO;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface ClassesFacade {

    ClassesResponseDTO save(ClassesRequestDTO classesRequestDTO, HttpServletRequest request);
    List<ClassesResponseDTO> getAllByEmail(HttpServletRequest request);
}
