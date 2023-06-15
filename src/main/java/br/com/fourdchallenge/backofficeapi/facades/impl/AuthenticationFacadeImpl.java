package br.com.fourdchallenge.backofficeapi.facades.impl;

import br.com.fourdchallenge.backofficeapi.dtos.auth.LoginRequestDTO;
import br.com.fourdchallenge.backofficeapi.dtos.auth.LoginResponseDTO;
import br.com.fourdchallenge.backofficeapi.facades.AuthenticationFacade;
import br.com.fourdchallenge.backofficeapi.mappers.UsersMapper;
import br.com.fourdchallenge.backofficeapi.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthenticationFacadeImpl implements AuthenticationFacade {

    private final AuthenticationService authenticationService;
    private final UsersMapper usersMapper;

    @Override
    public LoginResponseDTO signin(LoginRequestDTO loginRequestDTO) {
        return authenticationService.signin(loginRequestDTO);
    }
}
