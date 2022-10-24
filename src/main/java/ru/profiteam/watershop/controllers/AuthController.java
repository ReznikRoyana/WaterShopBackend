package ru.profiteam.watershop.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.profiteam.watershop.annotation.BaseApiResponse;
import ru.profiteam.watershop.annotation.BaseApiResponseEmpty;
import ru.profiteam.watershop.dto.response.AuthDto;
import ru.profiteam.watershop.dto.response.RegistrationDto;
import ru.profiteam.watershop.dto.response.SecurityAuthDto;
import ru.profiteam.watershop.service.AuthService;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RestController
@RequestMapping()
@Tag(name = "Authorization")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthController {
    AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @Operation(summary = "Авторизация пользователя")
    @BaseApiResponse
    @GetMapping("authorization")
    public SecurityAuthDto auth(AuthDto request){
        return authService.auth(request);
    }

    @Operation(summary = "Регистрация пользователя")
    @BaseApiResponseEmpty
    @PostMapping("registration")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void registration(@RequestBody RegistrationDto request) {
        authService.registration(request);
    }


}
