package ru.profiteam.watershop.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import ru.profiteam.watershop.domain.Manufacturer;
import ru.profiteam.watershop.domain.ProductToOrder;
import ru.profiteam.watershop.domain.enums.ProductContainerMaterialType;
import ru.profiteam.watershop.domain.enums.ProductType;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateProductDto {
    String name;
    ProductType productType;
    ProductContainerMaterialType productContainerMaterialType;
    int price;
    float volume;
    Long sellerId;
    Long manufactureId;
}
