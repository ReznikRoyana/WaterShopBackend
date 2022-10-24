package ru.profiteam.watershop.builder.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.profiteam.watershop.builder.SecurityAuthBuilder;
import ru.profiteam.watershop.builder.UserBuilder;
import ru.profiteam.watershop.domain.User;
import ru.profiteam.watershop.dto.response.AuthDto;
import ru.profiteam.watershop.dto.response.SecurityAuthDto;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class SecurityAuthBuilderImpl implements SecurityAuthBuilder {

    UserBuilder userBuilder;

    @Override
    public SecurityAuthDto build(User user, String token) {
        return SecurityAuthDto.builder()
                .user(userBuilder.build(user))
                .token(token)
                .build();
    }
}
