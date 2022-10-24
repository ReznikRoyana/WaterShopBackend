package ru.profiteam.watershop.service;
import ru.profiteam.watershop.dto.response.AuthDto;
import ru.profiteam.watershop.dto.response.RegistrationDto;
import ru.profiteam.watershop.dto.response.SecurityAuthDto;
import java.util.List;

public interface AuthService {
    SecurityAuthDto auth(AuthDto authDto);
    void registration(RegistrationDto request);

}