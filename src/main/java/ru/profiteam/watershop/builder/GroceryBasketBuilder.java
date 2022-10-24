package ru.profiteam.watershop.builder;

import ru.profiteam.watershop.domain.GroceryBasket;
import ru.profiteam.watershop.domain.Product;
import ru.profiteam.watershop.domain.User;
import ru.profiteam.watershop.dto.request.CreateGroceryBasketDto;
import ru.profiteam.watershop.dto.response.GroceryBasketDto;

public interface GroceryBasketBuilder {
    GroceryBasketDto build(GroceryBasket groceryBasket);

    GroceryBasket build(Product product, User user);


    void update(GroceryBasket groceryBasket, Product product, User user);
}
