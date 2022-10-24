package ru.profiteam.watershop.builder;

import ru.profiteam.watershop.domain.City;
import ru.profiteam.watershop.domain.Country;
import ru.profiteam.watershop.dto.request.CreateCityDto;
import ru.profiteam.watershop.dto.response.CityDto;

public interface CityBuilder {

    CityDto build(City city);

    City build(CreateCityDto request, Country country);

    void update(City city, CreateCityDto request, Country country);
}
