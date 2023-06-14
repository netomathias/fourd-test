package br.com.fourdchallenge.backofficeapi.mappers;

import br.com.fourdchallenge.backofficeapi.dtos.users.UserRequestDTO;
import br.com.fourdchallenge.backofficeapi.dtos.users.UserResponseDTO;
import br.com.fourdchallenge.backofficeapi.entities.users.UserEntity;
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
