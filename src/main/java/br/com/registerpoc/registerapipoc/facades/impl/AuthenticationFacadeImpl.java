package br.com.registerpoc.registerapipoc.facades.impl;

import br.com.registerpoc.registerapipoc.dtos.auth.LoginRequestDTO;
import br.com.registerpoc.registerapipoc.dtos.auth.LoginResponseDTO;
import br.com.registerpoc.registerapipoc.facades.AuthenticationFacade;
import br.com.registerpoc.registerapipoc.mappers.users.UsersMapper;
import br.com.registerpoc.registerapipoc.services.AuthenticationService;
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
