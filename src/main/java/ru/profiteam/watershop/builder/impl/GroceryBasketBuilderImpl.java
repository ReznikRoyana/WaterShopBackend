package ru.profiteam.watershop.builder.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.profiteam.watershop.builder.GroceryBasketBuilder;
import ru.profiteam.watershop.builder.ProductBuilder;
import ru.profiteam.watershop.builder.UserBuilder;
import ru.profiteam.watershop.domain.GroceryBasket;
import ru.profiteam.watershop.domain.Product;
import ru.profiteam.watershop.domain.User;
import ru.profiteam.watershop.dto.request.CreateGroceryBasketDto;
import ru.profiteam.watershop.dto.response.GroceryBasketDto;

import java.util.Date;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class GroceryBasketBuilderImpl implements GroceryBasketBuilder {

    UserBuilder userBuilder;
    ProductBuilder productBuilder;
    @Override
    public GroceryBasketDto build(GroceryBasket groceryBasket) {
        return GroceryBasketDto.builder()
                .id(groceryBasket.getId())
                .user(userBuilder.build(groceryBasket.getUser()))
                .product(productBuilder.build(groceryBasket.getProduct()))
                .build();
    }

    @Override
    public GroceryBasket build(Product product, User user) {
        GroceryBasket groceryBasket = new GroceryBasket();
        groceryBasket.setUser(user);
        groceryBasket.setProduct(product);
        groceryBasket.setCreatedAt(new Date());
        return groceryBasket;
    }

    @Override
    public void update(GroceryBasket groceryBasket, Product product, User user) {
        groceryBasket.setUser(user);
        groceryBasket.setProduct(product);
        groceryBasket.setUpdatedAt(new Date());
    }
}
