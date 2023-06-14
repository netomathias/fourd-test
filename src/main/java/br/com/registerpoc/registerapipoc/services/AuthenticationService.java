package br.com.registerpoc.registerapipoc.services;

import br.com.registerpoc.registerapipoc.dtos.auth.LoginRequestDTO;
import br.com.registerpoc.registerapipoc.dtos.auth.LoginResponseDTO;

public interface AuthenticationService {

    LoginResponseDTO signin(LoginRequestDTO loginRequestDTO);
}
