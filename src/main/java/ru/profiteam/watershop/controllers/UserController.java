package ru.profiteam.watershop.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;
import ru.profiteam.watershop.annotation.BaseApiResponse;
import ru.profiteam.watershop.annotation.BaseApiResponseEmpty;
import ru.profiteam.watershop.controllers.base.AuthorizationController;
import ru.profiteam.watershop.dto.response.UserDto;
import ru.profiteam.watershop.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RestController
@RequestMapping("user")
@Tag(name = "User")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController extends AuthorizationController {
    UserService userService;

    @Autowired
    public UserController(UserService userService, HttpServletRequest request) {
        super(request);
        this.userService = userService;
    }

//    @Operation(summary = "Получение userId по токену")
//    @BaseApiResponse
//    @PostMapping
//    public Long getUserId(@RequestBody String token){
//        return userService.getIdByToken(token);
//    }

//    @Operation(summary = "Авторизация пользователя (Получение токена)")
//    @BaseApiResponse
//    @PostMapping("auth")
//    public String auth(@RequestBody RegistrationDto request){
//        return userService.auth(request);
//    }
//
//    @Operation(summary = "Регистрация пользователя")
//    @BaseApiResponseEmpty
//    @PostMapping("registration")
//    public void registration(@RequestBody RegistrationDto request) {
//        userService.registration(request);
//    }

    @BaseApiResponse
    @GetMapping
    public List<UserDto> getAll() {
        return userService.getAll();
    }

    @BaseApiResponseEmpty
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }
}
