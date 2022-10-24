package ru.profiteam.watershop.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    Long id;
    String latitude;
    String longitude;
    CityDto city;
    String street;
    String house;
    String flat;
    String level;
    boolean elevator;

}
