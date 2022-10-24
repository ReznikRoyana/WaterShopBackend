package ru.profiteam.watershop.builder;

import ru.profiteam.watershop.domain.*;
import ru.profiteam.watershop.dto.request.CreateOrderDto;
import ru.profiteam.watershop.dto.response.OrderDto;

public interface OrderBuilder {

    OrderDto build(Order order);

    Order build(CreateOrderDto request, User user);

    void update(Order order, CreateOrderDto request, User user);
}
