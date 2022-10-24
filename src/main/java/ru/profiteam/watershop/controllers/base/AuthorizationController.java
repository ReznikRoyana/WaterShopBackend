package ru.profiteam.watershop.controllers.base;

import lombok.Setter;
import lombok.experimental.UtilityClass;
import org.springframework.beans.factory.annotation.Autowired;
import ru.profiteam.watershop.service.impl.TokenHelper;

import javax.servlet.http.HttpServletRequest;

@Setter
public abstract class AuthorizationController {

    protected Long userId;

    public AuthorizationController(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        setUserId(TokenHelper.parseJwt(token));
    }
}
