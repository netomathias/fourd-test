package br.com.fourdchallenge.backofficeapi.services;

import br.com.fourdchallenge.backofficeapi.entities.classes.ClassesEntity;

import java.util.List;

public interface ClassesService {

    ClassesEntity save(ClassesEntity classesEntity);
    List<ClassesEntity> getAllByUsername(String email);
}
