package br.com.registerpoc.registerapipoc.services.impl;

import br.com.registerpoc.registerapipoc.entities.classes.ClassesEntity;
import br.com.registerpoc.registerapipoc.repositories.ClassesRepository;
import br.com.registerpoc.registerapipoc.services.ClassesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClassesServiceImpl implements ClassesService{

    private final ClassesRepository classesRepository;

    @Override
    public ClassesEntity save(ClassesEntity classesEntity) {
        log.info("saving new class - {}", classesEntity);
        return classesRepository.save(classesEntity);
    }

    @Override
    public List<ClassesEntity> getAllByUsername(String email) {
        log.info("getting all classes for user - {}", email);
        return classesRepository.findAllByUserEmail(email);
    }
}
