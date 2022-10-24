package ru.profiteam.watershop.builder.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.profiteam.watershop.builder.CityBuilder;
import ru.profiteam.watershop.builder.CountryBuilder;
import ru.profiteam.watershop.domain.City;
import ru.profiteam.watershop.domain.Country;
import ru.profiteam.watershop.dto.request.CreateCityDto;
import ru.profiteam.watershop.dto.response.CityDto;
import ru.profiteam.watershop.dto.response.CountryDto;

import java.util.Date;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CityBuilderImpl implements CityBuilder {
    CountryBuilder countryBuilder;

    @Override
    public CityDto build(City city) {
        return CityDto.builder()
                .id(city.getId())
                .name(city.getName())
                .country(countryBuilder.build(city.getCountry()))
                .build();
    }

    @Override
    public City build(CreateCityDto request, Country country) {
        City city = new City();
        city.setName(request.getName());
        city.setCreatedAt(new Date());
        city.setCountry(country);
        return city;
    }

    @Override
    public void update(City city, CreateCityDto request, Country country) {
        city.setName(request.getName());
        city.setCountry(country);
        city.setUpdatedAt(new Date());
    }

}
