package br.com.fourdchallenge.backofficeapi.controllers;

import br.com.fourdchallenge.backofficeapi.dtos.users.UserResponseDTO;
import br.com.fourdchallenge.backofficeapi.facades.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserFacade userFacade;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public List<UserResponseDTO> getAll() {
        return userFacade.getAll();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/approval-accounts")
    public ResponseEntity<UserResponseDTO> approveAccount(@RequestParam String email) {
        return new ResponseEntity<>(userFacade.approveAccount(email), HttpStatus.OK);
    }
}
