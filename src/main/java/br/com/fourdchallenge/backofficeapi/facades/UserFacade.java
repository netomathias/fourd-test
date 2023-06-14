package br.com.fourdchallenge.backofficeapi.facades;

import br.com.fourdchallenge.backofficeapi.dtos.users.UserRequestDTO;
import br.com.fourdchallenge.backofficeapi.dtos.users.UserResponseDTO;

import java.util.List;

public interface UserFacade {

    UserResponseDTO save(UserRequestDTO userRequestDTO);
    List<UserResponseDTO> getAll();
    UserResponseDTO approveAccount(String email);
}
