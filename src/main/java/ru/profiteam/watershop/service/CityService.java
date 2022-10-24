package ru.profiteam.watershop.service;

import ru.profiteam.watershop.dto.request.CreateCityDto;
import ru.profiteam.watershop.dto.request.CreateManufacturerDto;
import ru.profiteam.watershop.dto.response.CityDto;
import java.util.List;

public interface CityService {
    void create(CreateCityDto request);
    List<CityDto> getAll();
    CityDto getById(Long id);
    void update(Long id, CreateCityDto request);
    void deleteById(Long id);
}
