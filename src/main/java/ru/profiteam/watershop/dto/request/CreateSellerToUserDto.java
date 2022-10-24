package ru.profiteam.watershop.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import ru.profiteam.watershop.dto.response.SellerDto;
import ru.profiteam.watershop.dto.response.UserDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateSellerToUserDto {
    Long sellerId;
    Long userId;
}
