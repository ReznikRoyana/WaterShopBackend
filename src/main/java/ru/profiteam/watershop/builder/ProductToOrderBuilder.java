package ru.profiteam.watershop.builder;

import ru.profiteam.watershop.domain.*;
import ru.profiteam.watershop.dto.request.CreateProductToOrderDto;
import ru.profiteam.watershop.dto.response.ProductToOrderDto;

public interface ProductToOrderBuilder {

    ProductToOrderDto build(ProductToOrder productToOrder);

    ProductToOrder build(Product product, Order order, int count);

    void update(ProductToOrder productToOrder,
                CreateProductToOrderDto request,
                Product product,
                Order order);

}
