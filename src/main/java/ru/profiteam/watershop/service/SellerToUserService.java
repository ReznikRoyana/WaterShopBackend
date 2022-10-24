package ru.profiteam.watershop.service;

import ru.profiteam.watershop.dto.request.CreateManufacturerDto;
import ru.profiteam.watershop.dto.request.CreateSellerToUserDto;

public interface SellerToUserService {
    void create(CreateSellerToUserDto request);
}
