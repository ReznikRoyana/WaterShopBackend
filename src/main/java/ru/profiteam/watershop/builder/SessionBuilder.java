package ru.profiteam.watershop.builder;

import ru.profiteam.watershop.domain.*;
import ru.profiteam.watershop.dto.request.CreateSessionDto;
import ru.profiteam.watershop.dto.response.SessionDto;

public interface SessionBuilder {

    SessionDto build(Session session);

    Session build(CreateSessionDto request,
                  User user);

    void update(Session session,
                CreateSessionDto request,
                User user);
}
