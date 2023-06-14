package br.com.fourdchallenge.backofficeapi.controllers;

import br.com.fourdchallenge.backofficeapi.dtos.auth.LoginResponseDTO;
import br.com.fourdchallenge.backofficeapi.dtos.auth.LoginRequestDTO;
import br.com.fourdchallenge.backofficeapi.dtos.users.UserRequestDTO;
import br.com.fourdchallenge.backofficeapi.dtos.users.UserResponseDTO;
import br.com.fourdchallenge.backofficeapi.facades.UserFacade;
import br.com.fourdchallenge.backofficeapi.services.impl.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
