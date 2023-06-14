package br.com.registerpoc.registerapipoc.facades.impl;

import br.com.registerpoc.registerapipoc.dtos.users.UserRequestDTO;
import br.com.registerpoc.registerapipoc.dtos.users.UserResponseDTO;
import br.com.registerpoc.registerapipoc.facades.UserFacade;
import br.com.registerpoc.registerapipoc.mappers.UsersMapper;
import br.com.registerpoc.registerapipoc.services.UserService;
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
