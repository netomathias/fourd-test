package br.com.registerpoc.registerapipoc.mappers;

import br.com.registerpoc.registerapipoc.dtos.users.UserRequestDTO;
import br.com.registerpoc.registerapipoc.dtos.users.UserResponseDTO;
import br.com.registerpoc.registerapipoc.entities.users.UserEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsersMapper {

    private final ModelMapper modelMapper;

    public UserEntity DTOToEntity(UserRequestDTO userRequestDTO) {
        return modelMapper.map(userRequestDTO, UserEntity.class);
    }

    public UserResponseDTO EntityToDTO(UserEntity userEntity) {
        return modelMapper.map(userEntity, UserResponseDTO.class);
    }
}
