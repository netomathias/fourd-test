package br.com.registerpoc.registerapipoc.services;

import br.com.registerpoc.registerapipoc.entities.classes.ClassesEntity;

import java.util.List;

public interface ClassesService {

    ClassesEntity save(ClassesEntity classesEntity);
    List<ClassesEntity> getAllByUsername(String email);
}
