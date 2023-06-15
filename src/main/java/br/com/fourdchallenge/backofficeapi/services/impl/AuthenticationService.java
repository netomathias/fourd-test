package br.com.fourdchallenge.backofficeapi.services.impl;

import br.com.fourdchallenge.backofficeapi.dtos.auth.LoginResponseDTO;
import br.com.fourdchallenge.backofficeapi.repositories.UserRepository;
import br.com.fourdchallenge.backofficeapi.dtos.auth.LoginRequestDTO;
import br.com.fourdchallenge.backofficeapi.entities.users.AccountStatusEnum;
import br.com.fourdchallenge.backofficeapi.entities.users.UserEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationService implements br.com.fourdchallenge.backofficeapi.services.AuthenticationService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public LoginResponseDTO signin(LoginRequestDTO loginRequestDTO) {
        log.info("signing in user - {}", loginRequestDTO);
        try {
            Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDTO.getEmail(), loginRequestDTO.getPassword()));

            UserEntity user = (UserEntity) authenticate.getPrincipal();

            verifyAccountStatus(user);

            Map<String, Object> extraClaims = new HashMap<>();
            extraClaims.put("user-id", user.getId());
            var jwtToken = jwtService.generateToken(extraClaims, user);

            return LoginResponseDTO.builder()
                    .token(jwtToken)
                    .build();
        } catch (UsernameNotFoundException e) {
            log.error("bad credentials");
            throw new UsernameNotFoundException(e.getMessage());
        }
    }

    private void verifyAccountStatus(UserEntity user) {
        log.info("verifying account status for user - {}", user);
        if (user.getAccountStatus() == AccountStatusEnum.WAITING_APPROVAL) {
            log.error("account not approved");
            throw new SecurityException("account waiting approval");
        }
    }
}

