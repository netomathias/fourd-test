package br.com.fourdchallenge.backofficeapi.facades;

import br.com.fourdchallenge.backofficeapi.dtos.auth.LoginRequestDTO;
import br.com.fourdchallenge.backofficeapi.dtos.auth.LoginResponseDTO;

public interface AuthenticationFacade {
    LoginResponseDTO signin(LoginRequestDTO loginRequestDTO);
}
