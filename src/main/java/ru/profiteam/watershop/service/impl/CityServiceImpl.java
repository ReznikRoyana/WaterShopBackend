package ru.profiteam.watershop.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.profiteam.watershop.builder.CityBuilder;
import ru.profiteam.watershop.domain.City;
import ru.profiteam.watershop.domain.Country;
import ru.profiteam.watershop.dto.request.CreateCityDto;
import ru.profiteam.watershop.dto.response.CityDto;
import ru.profiteam.watershop.repository.CityRepository;
import ru.profiteam.watershop.repository.CountryRepository;
import ru.profiteam.watershop.service.CityService;

import java.util.*;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    CityRepository cityRepository;
    CityBuilder cityBuilder;
    CountryRepository countryRepository;

    @Override
    public void create(CreateCityDto request) {
        Optional<Country> countryOpt = countryRepository.findById(request.getCountryId());
        if (countryOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        City city = cityBuilder.build(request, countryOpt.get());
        cityRepository.save(city);
    }

    @Override
    public List<CityDto> getAll() {
        List<City> cityList = cityRepository.findAll();
        List<CityDto> cityDtoList = new ArrayList<>();
        for (City item : cityList) {
            cityDtoList.add(cityBuilder.build(item));
        }
        return cityDtoList;
    }

    @Override
    public CityDto getById(Long id) {
        Optional<City> cityOpt = cityRepository.findById(id);
        if (cityOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return cityBuilder.build(cityOpt.get());
    }

    @Override
    public void update(Long id, CreateCityDto request) {
        Optional<City> cityOpt = cityRepository.findById(id);
        if (cityOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Optional<Country> countryOpt = countryRepository.findById(id);
        if (countryOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        City updateCity = cityOpt.get();
        cityBuilder.update(updateCity, request, countryOpt.get());
    }

    @Override
    public void deleteById(Long id) {
        Optional<City> cityOpt = cityRepository.findById(id);
        if (cityOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        cityRepository.deleteById(id);
    }
}
