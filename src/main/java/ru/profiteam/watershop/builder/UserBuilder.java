package ru.profiteam.watershop.builder;

import ru.profiteam.watershop.domain.Address;
import ru.profiteam.watershop.domain.City;
import ru.profiteam.watershop.domain.User;
import ru.profiteam.watershop.dto.request.CreateUserDto;
import ru.profiteam.watershop.dto.response.RegistrationDto;
import ru.profiteam.watershop.dto.response.UserDto;

public interface UserBuilder {

    UserDto build(User user);

    User build(CreateUserDto request,
               City city,
               Address address);

    void update(User user,
                CreateUserDto request,
                City city,
                Address address);

     User regBuild(RegistrationDto request);
}
