package br.com.fourdchallenge.backofficeapi.facades.impl;

import br.com.fourdchallenge.backofficeapi.dtos.users.UserResponseDTO;
import br.com.fourdchallenge.backofficeapi.mappers.UsersMapper;
import br.com.fourdchallenge.backofficeapi.services.UserService;
import br.com.fourdchallenge.backofficeapi.dtos.users.UserRequestDTO;
import br.com.fourdchallenge.backofficeapi.facades.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserFacadeImpl implements UserFacade {

    private final UserService userService;
    private final UsersMapper usersMapper;

    @Override
    public UserResponseDTO save(UserRequestDTO userRequestDTO) {
        return usersMapper.EntityToDTO(userService.save(usersMapper.DTOToEntity(userRequestDTO)));
    }

    @Override
    public List<UserResponseDTO> getAll() {
        return userService.getAll().stream().map(usersMapper::EntityToDTO).toList();
    }

    @Override
    public UserResponseDTO approveAccount(String email) {
        return usersMapper.EntityToDTO(userService.approveAccount(email));
    }
}
