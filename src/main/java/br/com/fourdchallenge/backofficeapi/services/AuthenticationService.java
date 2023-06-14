package br.com.fourdchallenge.backofficeapi.services;

import br.com.fourdchallenge.backofficeapi.dtos.auth.LoginRequestDTO;
import br.com.fourdchallenge.backofficeapi.dtos.auth.LoginResponseDTO;

public interface AuthenticationService {

    LoginResponseDTO signin(LoginRequestDTO loginRequestDTO);
}
