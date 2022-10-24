package ru.profiteam.watershop.builder;

import ru.profiteam.watershop.domain.Country;
import ru.profiteam.watershop.dto.request.CreateCountryDto;
import ru.profiteam.watershop.dto.response.CountryDto;

public interface CountryBuilder {

    CountryDto build(Country country);

    Country build(CreateCountryDto request);

    void update(Country country, CreateCountryDto request);
}
