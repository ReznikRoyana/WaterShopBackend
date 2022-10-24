package ru.profiteam.watershop.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import ru.profiteam.watershop.domain.enums.PayMethodType;
import ru.profiteam.watershop.dto.response.SelectProductDto;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateOrderDto {
    Long userId;
    String name;
    String address;
    String phoneNumber;
    PayMethodType payMethodType;
    List<SelectProductDto> products;
}
