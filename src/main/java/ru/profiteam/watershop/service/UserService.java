package ru.profiteam.watershop.service;

import ru.profiteam.watershop.dto.response.RegistrationDto;
import ru.profiteam.watershop.dto.response.UserDto;

import java.util.List;

public interface UserService {
//    String auth(RegistrationDto request);
//
//    Long getIdByToken(String token);
//
//    void registration(RegistrationDto request);

    List<UserDto> getAll();

    void deleteById(Long id);
}


