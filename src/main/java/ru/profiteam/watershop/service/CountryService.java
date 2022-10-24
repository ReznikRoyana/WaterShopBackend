package ru.profiteam.watershop.service;

import ru.profiteam.watershop.dto.request.CreateCountryDto;
import ru.profiteam.watershop.dto.response.CountryDto;

import java.util.List;

public interface CountryService {
    void create(CreateCountryDto request);
    List<CountryDto> getAll();
    CountryDto getById(Long id);
    void update(Long id, CreateCountryDto request);
    void deleteById(Long id);
}
