package ru.profiteam.watershop.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.profiteam.watershop.domain.enums.UserType;
import ru.profiteam.watershop.dto.response.AddressDto;
import ru.profiteam.watershop.dto.response.CityDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateUserDto {
    UserType type;
    String fullName;
    String login;
    String password;
//    String email;
    String phoneNumber;
//    Long cityId;
//    Long addressId;
}
