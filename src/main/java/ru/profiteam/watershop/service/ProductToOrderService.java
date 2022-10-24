package ru.profiteam.watershop.service;

import ru.profiteam.watershop.dto.request.CreateManufacturerDto;
import ru.profiteam.watershop.dto.request.CreateProductDto;

public interface ProductToOrderService {
    void create(CreateProductDto request);
}
