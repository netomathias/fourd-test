package br.com.fourdchallenge.backofficeapi.services;

import br.com.fourdchallenge.backofficeapi.entities.users.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity update(String id, UserEntity userEntity);
    UserEntity save(UserEntity userEntity);
    List<UserEntity> getAll();
    UserEntity getById(String id);
    void deleteById(String id);
    UserEntity approveAccount(String email);
}
