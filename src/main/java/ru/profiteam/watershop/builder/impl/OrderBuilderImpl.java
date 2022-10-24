package ru.profiteam.watershop.builder.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.profiteam.watershop.builder.OrderBuilder;
import ru.profiteam.watershop.builder.UserBuilder;
import ru.profiteam.watershop.domain.Order;
import ru.profiteam.watershop.domain.User;
import ru.profiteam.watershop.dto.request.CreateOrderDto;
import ru.profiteam.watershop.dto.response.OrderDto;

import java.util.Date;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class OrderBuilderImpl implements OrderBuilder {

    UserBuilder userBuilder;

    @Override
    public OrderDto build(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .user(userBuilder.build(order.getUser()))
                .name(order.getName())
                .address(order.getAddress())
                .phoneNumber(order.getPhoneNumber())
                .payMethodType(order.getPayMethodType())
                .build();
    }

    @Override
    public Order build(CreateOrderDto request,
                       User user) {
        Order order = new Order();
        order.setUser(user);
        order.setName(request.getName());
        order.setAddress(request.getAddress());
        order.setPhoneNumber(request.getPhoneNumber());
        order.setPayMethodType(request.getPayMethodType());
        order.setCreatedAt(new Date());
        return order;
    }

    @Override
    public void update(Order order,
                       CreateOrderDto request,
                       User user) {
        order.setUser(user);
        order.setName(request.getName());
        order.setAddress(request.getAddress());
        order.setPhoneNumber(request.getPhoneNumber());
        order.setPayMethodType(request.getPayMethodType());
        order.setUpdatedAt(new Date());
    }
}
