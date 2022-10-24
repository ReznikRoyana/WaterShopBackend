package ru.profiteam.watershop.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.profiteam.watershop.domain.enums.UserType;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    Long id;
    UserType type;
    String fullName;
    String login;
    String password;
//    String email;
    String phoneNumber;
//    CityDto city;
//    AddressDto address;
}
