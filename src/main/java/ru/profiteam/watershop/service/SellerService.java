package ru.profiteam.watershop.service;

import ru.profiteam.watershop.dto.request.CreateManufacturerDto;
import ru.profiteam.watershop.dto.request.CreateSellerDto;
import ru.profiteam.watershop.dto.response.SellerDto;

import java.util.List;

public interface SellerService {
    void create(CreateSellerDto request);
    List<SellerDto> getAll();
    void deleteById(Long id);
    SellerDto getById(Long id);
}
