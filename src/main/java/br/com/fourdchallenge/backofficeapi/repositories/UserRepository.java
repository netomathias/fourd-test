package br.com.fourdchallenge.backofficeapi.repositories;

import br.com.fourdchallenge.backofficeapi.entities.users.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {

    Optional<UserEntity> findByEmail(String email);
}
