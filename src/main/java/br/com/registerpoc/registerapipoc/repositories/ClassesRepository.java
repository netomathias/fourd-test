package br.com.registerpoc.registerapipoc.repositories;

import br.com.registerpoc.registerapipoc.entities.classes.ClassesEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClassesRepository extends MongoRepository<ClassesEntity, String> {

    List<ClassesEntity> findAllByUserEmail(String email);
}
