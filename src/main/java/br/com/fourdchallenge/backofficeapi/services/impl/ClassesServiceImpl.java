package br.com.fourdchallenge.backofficeapi.services.impl;

import br.com.fourdchallenge.backofficeapi.entities.classes.ClassesEntity;
import br.com.fourdchallenge.backofficeapi.repositories.ClassesRepository;
import br.com.fourdchallenge.backofficeapi.services.ClassesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClassesServiceImpl implements ClassesService{

    private final ClassesRepository classesRepository;

    @Override
    @CacheEvict(value = "classes" , allEntries = true)
    public ClassesEntity save(ClassesEntity classesEntity) {
        log.info("saving new class - {}", classesEntity);
        return classesRepository.save(classesEntity);
    }

    @Override
    @Cacheable(value = "classes")
    public List<ClassesEntity> getAllByUsername(String email) {
        log.info("getting all classes for user - {}", email);
        return classesRepository.findAllByUserEmail(email);
    }
}
