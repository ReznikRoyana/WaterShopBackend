package ru.profiteam.watershop.builder.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.profiteam.watershop.builder.SessionBuilder;
import ru.profiteam.watershop.builder.UserBuilder;
import ru.profiteam.watershop.domain.Session;
import ru.profiteam.watershop.domain.User;
import ru.profiteam.watershop.dto.request.CreateSessionDto;
import ru.profiteam.watershop.dto.response.SessionDto;

import java.util.Date;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class SessionBuilderImpl implements SessionBuilder {

    UserBuilder userBuilder;

    @Override
    public SessionDto build(Session session) {
        return SessionDto.builder()
                .id(session.getId())
                .loginDate(session.getLoginDate())
                .logoutDate(session.getLogoutDate())
                .user(userBuilder.build(session.getUser()))
                .token(session.getToken())
                .build();
    }

    @Override
    public Session build(CreateSessionDto request, User user) {
        Session session = new Session();
        session.setLoginDate(request.getLoginDate());
        session.setLogoutDate(request.getLogoutDate());
        session.setUser(user);
        session.setToken(session.getToken());
        session.setCreatedAt(new Date());
        return session;
    }

    @Override
    public void update(Session session, CreateSessionDto request, User user) {
        session.setLoginDate(request.getLoginDate());
        session.setLogoutDate(request.getLogoutDate());
        session.setUser(user);
        session.setToken(request.getToken());
        session.setUpdatedAt(new Date());
    }
}
