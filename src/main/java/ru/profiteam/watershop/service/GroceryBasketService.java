package ru.profiteam.watershop.service;
import ru.profiteam.watershop.dto.request.CreateGroceryBasketDto;
import ru.profiteam.watershop.dto.response.GroceryBasketDto;

import java.util.List;

public interface GroceryBasketService {
    void create(CreateGroceryBasketDto request);
    List<GroceryBasketDto> getAll();
    GroceryBasketDto getById(Long id);
    void update(Long id, GroceryBasketDto request);
    void deleteById(Long id);
}
