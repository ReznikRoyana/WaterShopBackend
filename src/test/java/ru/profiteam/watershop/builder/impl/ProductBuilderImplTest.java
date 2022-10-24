package ru.profiteam.watershop.builder.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.profiteam.watershop.builder.ManufacturerBuilderTest;
import ru.profiteam.watershop.builder.ProductBuilderTest;
import ru.profiteam.watershop.builder.SellerBuilderTest;
import ru.profiteam.watershop.domain.Product;
import ru.profiteam.watershop.domain.enums.ProductContainerMaterialType;
import ru.profiteam.watershop.domain.enums.ProductType;

import java.util.Date;
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ProductBuilderImplTest implements ProductBuilderTest {
    @Autowired
    ManufacturerBuilderTest manufacturerBuilderTest;
    @Autowired
    SellerBuilderTest sellerBuilderTest;
    @Override
    public Product build() {
        Product product = new Product();
        product.setId(2L);
        product.setCreatedAt(new Date());
        product.setName("name");
        product.setPrice(1);
        product.setProductContainerMaterialType(ProductContainerMaterialType.GLASS);
        product.setProductType(ProductType.STILL);
        product.setVolume(1F);
        product.setManufacturer(manufacturerBuilderTest.build());
        product.setSeller(sellerBuilderTest.build());
        return product;
    }
}
