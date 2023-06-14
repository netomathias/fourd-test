package br.com.registerpoc.registerapipoc.facades;

import br.com.registerpoc.registerapipoc.dtos.auth.LoginRequestDTO;
import br.com.registerpoc.registerapipoc.dtos.auth.LoginResponseDTO;
import br.com.registerpoc.registerapipoc.dtos.users.UserRequestDTO;
import br.com.registerpoc.registerapipoc.dtos.users.UserResponseDTO;

public interface AuthenticationFacade {
    LoginResponseDTO signin(LoginRequestDTO loginRequestDTO);
}
