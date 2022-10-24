package ru.profiteam.watershop.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.profiteam.watershop.domain.User;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SellerToUserDto {
    Long id;
    SellerDto seller;
    UserDto user;
}
