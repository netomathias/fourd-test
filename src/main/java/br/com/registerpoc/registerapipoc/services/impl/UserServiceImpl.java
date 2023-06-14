package br.com.registerpoc.registerapipoc.services.impl;

import br.com.registerpoc.registerapipoc.entities.AccountStatusEnum;
import br.com.registerpoc.registerapipoc.entities.RoleEnum;
import br.com.registerpoc.registerapipoc.entities.UserEntity;
import br.com.registerpoc.registerapipoc.exceptions.AccountAlreadyApprovedException;
import br.com.registerpoc.registerapipoc.repositories.UserRepository;
import br.com.registerpoc.registerapipoc.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserEntity save(UserEntity userEntity) {
        userEntity.setRoleEnum(RoleEnum.USER);
        userEntity.setAccountStatus(AccountStatusEnum.WAITING_APPROVAL);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));

        log.info("saving new user - {}", userEntity);
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity update(String id, UserEntity userEntity) {
        log.info("updating user - {}", userEntity);
        userEntity.setId(id);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        return userRepository.save(userEntity);
    }

    @Override
    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("user not found exists"));
    }

    @Override
    public void deleteById(String id) {
        getById(id);
        userRepository.deleteById(id);
    }

    @Override
    public UserEntity approveAccount(String email) {
        log.info("approving account - {}", email);
        UserEntity user = userRepository.findByEmail(email).orElseThrow(() -> new NotFoundException("user not found"));

        if (!user.getAccountStatus().equals(AccountStatusEnum.WAITING_APPROVAL)) {
            log.error("account already approved");
            throw new AccountAlreadyApprovedException("account already approved");
        }
        user.setAccountStatus(AccountStatusEnum.APPROVED);

        return userRepository.save(user);
    }
}
