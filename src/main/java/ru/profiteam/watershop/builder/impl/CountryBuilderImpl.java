package ru.profiteam.watershop.builder.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.profiteam.watershop.builder.CountryBuilder;
import ru.profiteam.watershop.domain.Country;
import ru.profiteam.watershop.dto.request.CreateCountryDto;
import ru.profiteam.watershop.dto.response.CountryDto;
import java.util.Date;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CountryBuilderImpl implements CountryBuilder {
    @Override
    public CountryDto build(Country country) {
        return CountryDto.builder()
                .id(country.getId())
                .name(country.getName())
                .build();
    }

    @Override
    public Country build(CreateCountryDto request) {
        Country country = new Country();
        country.setName(request.getName());
        country.setCreatedAt(new Date());
        return country;
    }

    @Override
    public void update(Country country, CreateCountryDto request) {
        country.setName(request.getName());
        country.setUpdatedAt(new Date());
    }
}
