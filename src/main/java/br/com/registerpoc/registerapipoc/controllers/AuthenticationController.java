package br.com.registerpoc.registerapipoc.controllers;

import br.com.registerpoc.registerapipoc.dtos.auth.LoginRequestDTO;
import br.com.registerpoc.registerapipoc.dtos.auth.LoginResponseDTO;
import br.com.registerpoc.registerapipoc.dtos.users.UserRequestDTO;
import br.com.registerpoc.registerapipoc.dtos.users.UserResponseDTO;
import br.com.registerpoc.registerapipoc.facades.UserFacade;
import br.com.registerpoc.registerapipoc.services.impl.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final UserFacade userFacade;

    @PostMapping("/sign-in")
    public ResponseEntity<LoginResponseDTO> signin(@RequestBody LoginRequestDTO loginRequestDTO) {
        return new ResponseEntity<>(authenticationService.signin(loginRequestDTO), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/sign-up")
    public ResponseEntity<UserResponseDTO> signup(@RequestBody UserRequestDTO userRequestDTO) {
        return new ResponseEntity<>(userFacade.save(userRequestDTO), HttpStatusCode.valueOf(200));
    }
}
