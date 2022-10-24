package ru.profiteam.watershop.builder.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.profiteam.watershop.builder.OrderBuilder;
import ru.profiteam.watershop.builder.ProductBuilder;
import ru.profiteam.watershop.builder.ProductToOrderBuilder;
import ru.profiteam.watershop.domain.Order;
import ru.profiteam.watershop.domain.Product;
import ru.profiteam.watershop.domain.ProductToOrder;
import ru.profiteam.watershop.dto.request.CreateProductToOrderDto;
import ru.profiteam.watershop.dto.response.ProductToOrderDto;

import java.util.Date;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ProductToUserBuilderImpl implements ProductToOrderBuilder {

    ProductBuilder productBuilder;
    OrderBuilder orderBuilder;

    @Override
    public ProductToOrderDto build(ProductToOrder productToOrder) {
        return ProductToOrderDto.builder()
                .id(productToOrder.getId())
                .product(productBuilder.build(productToOrder.getProduct()))
                .order(orderBuilder.build(productToOrder.getOrder()))
                .count(productToOrder.getCount())
                .build();
    }

    @Override
    public ProductToOrder build(Product product, Order order, int count) {
        ProductToOrder productToOrder = new ProductToOrder();
        productToOrder.setProduct(product);
        productToOrder.setOrder(order);
        productToOrder.setCount(count);
        productToOrder.setCreatedAt(new Date());
        return productToOrder;
    }

    @Override
    public void update(ProductToOrder productToOrder,
                       CreateProductToOrderDto request,
                       Product product,
                       Order order) {
        productToOrder.setProduct(product);
        productToOrder.setOrder(order);
        productToOrder.setCount(request.getCount());
        productToOrder.setUpdatedAt(new Date());

    }
}
