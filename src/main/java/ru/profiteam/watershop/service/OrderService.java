package ru.profiteam.watershop.service;

import ru.profiteam.watershop.dto.request.CreateManufacturerDto;
import ru.profiteam.watershop.dto.request.CreateOrderDto;
import ru.profiteam.watershop.dto.response.OrderDto;

import java.util.List;

public interface OrderService {
    void create(CreateOrderDto request);
    List<OrderDto> getAll();
    List<OrderDto> getByUserId(Long id);
}
