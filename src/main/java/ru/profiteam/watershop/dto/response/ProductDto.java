package ru.profiteam.watershop.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.profiteam.watershop.domain.enums.ProductContainerMaterialType;
import ru.profiteam.watershop.domain.enums.ProductType;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    long id;
    String name;
    ProductType productType;
    ProductContainerMaterialType productContainerMaterialType;
    int price;
    float volume;
    SellerDto seller;
    ManufacturerDto manufacturer;
}
