package ru.profiteam.watershop.builder;

import ru.profiteam.watershop.domain.User;
import ru.profiteam.watershop.dto.response.AuthDto;
import ru.profiteam.watershop.dto.response.SecurityAuthDto;

public interface SecurityAuthBuilder {
    SecurityAuthDto build(User user, String token);
}
