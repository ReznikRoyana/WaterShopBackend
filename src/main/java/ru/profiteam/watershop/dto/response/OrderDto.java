package ru.profiteam.watershop.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.profiteam.watershop.domain.enums.PayMethodType;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    Long id;
    UserDto user;
    String name;
    String address;
    String phoneNumber;
    PayMethodType payMethodType;
    List<SelectProductDto> products;
}
