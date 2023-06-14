package br.com.fourdchallenge.backofficeapi.repositories;

import br.com.fourdchallenge.backofficeapi.entities.classes.ClassesEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassesRepository extends MongoRepository<ClassesEntity, String> {

    List<ClassesEntity> findAllByUserEmail(String email);
}
