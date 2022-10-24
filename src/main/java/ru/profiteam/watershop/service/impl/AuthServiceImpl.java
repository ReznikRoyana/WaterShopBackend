package ru.profiteam.watershop.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.server.ResponseStatusException;
import ru.profiteam.watershop.builder.SecurityAuthBuilder;
import ru.profiteam.watershop.builder.UserBuilder;
import ru.profiteam.watershop.domain.User;
import ru.profiteam.watershop.dto.response.AuthDto;
import ru.profiteam.watershop.dto.response.RegistrationDto;
import ru.profiteam.watershop.dto.response.SecurityAuthDto;
import ru.profiteam.watershop.repository.ApproveCodeRepository;
import ru.profiteam.watershop.repository.UserRepository;
import ru.profiteam.watershop.service.AuthService;

import java.util.Optional;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    ApproveCodeRepository approveCodeRepository;
    UserRepository userRepository;
    UserBuilder userBuilder;
    SecurityAuthBuilder securityAuthBuilder;

    @Override
    public SecurityAuthDto auth(AuthDto request) {
        Optional<User> userOpt = userRepository.findFirstByLogin(request.getLogin());
        if (userOpt.isEmpty() || !DigestUtils.md5DigestAsHex(request.getPassword().getBytes()).equals(userOpt.get().getPassword())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return securityAuthBuilder.build(userOpt.get(),  TokenHelper.buildToken(userOpt.get().getId()));
    }

    @Override
    public void registration(RegistrationDto request) {
        if (request.getPassword().length() < 6) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        var approveLoginOpt = approveCodeRepository
                .findFirstByNumber(request.getLogin());
        if (approveLoginOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        }
        var userLoginOpt = userRepository.findFirstByLogin(request.getLogin());
        if (userLoginOpt.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        var entityUser = userBuilder.regBuild(request);
        userRepository.save(entityUser);
    }
}