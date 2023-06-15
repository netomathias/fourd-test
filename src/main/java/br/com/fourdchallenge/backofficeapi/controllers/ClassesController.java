package br.com.fourdchallenge.backofficeapi.controllers;

import br.com.fourdchallenge.backofficeapi.dtos.classes.ClassesRequestDTO;
import br.com.fourdchallenge.backofficeapi.dtos.classes.ClassesResponseDTO;
import br.com.fourdchallenge.backofficeapi.facades.ClassesFacade;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/classes")
@RequiredArgsConstructor
@Slf4j
public class ClassesController {

    private final ClassesFacade classesFacade;

    @PostMapping
    public ResponseEntity<ClassesResponseDTO> save(@RequestBody ClassesRequestDTO classesRequestDTO, HttpServletRequest request) {
        return new ResponseEntity<>(classesFacade.save(classesRequestDTO, request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ClassesResponseDTO>> getAllByUserEmail(HttpServletRequest request) {
        return new ResponseEntity<>(classesFacade.getAllByEmail(request), HttpStatus.OK);
    }
}
