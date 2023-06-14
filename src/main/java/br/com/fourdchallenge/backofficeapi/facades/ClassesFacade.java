package br.com.fourdchallenge.backofficeapi.facades;

import br.com.fourdchallenge.backofficeapi.dtos.classes.ClassesRequestDTO;
import br.com.fourdchallenge.backofficeapi.dtos.classes.ClassesResponseDTO;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface ClassesFacade {

    ClassesResponseDTO save(ClassesRequestDTO classesRequestDTO, HttpServletRequest request);
    List<ClassesResponseDTO> getAllByEmail(HttpServletRequest request);
}
