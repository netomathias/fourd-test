package br.com.registerpoc.registerapipoc.facades;

import br.com.registerpoc.registerapipoc.dtos.users.UserRequestDTO;
import br.com.registerpoc.registerapipoc.dtos.users.UserResponseDTO;

import java.util.List;

public interface UserFacade {

    UserResponseDTO save(UserRequestDTO userRequestDTO);
    List<UserResponseDTO> getAll();
    UserResponseDTO approveAccount(String email);
}
