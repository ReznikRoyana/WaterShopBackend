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
import ru.profiteam.watershop.builder.CountryBuilder;
import ru.profiteam.watershop.domain.City;
import ru.profiteam.watershop.domain.Country;
import ru.profiteam.watershop.domain.Product;
import ru.profiteam.watershop.dto.request.CreateCountryDto;
import ru.profiteam.watershop.dto.response.CountryDto;
import ru.profiteam.watershop.repository.CountryRepository;
import ru.profiteam.watershop.service.CountryService;

import java.util.*;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    CountryRepository countryRepository;
    CountryBuilder countryBuilder;

    @Override
    public void create(CreateCountryDto request) {
        Country country = countryBuilder.build(request);
        countryRepository.save(country);
    }

    @Override
    public List<CountryDto> getAll() {
        List<Country> countryList = countryRepository.findAll();
        List<CountryDto> countryDtoList = new ArrayList<>();
        for (Country item : countryList) {
            countryDtoList.add(countryBuilder.build(item));
        }
        return countryDtoList;
    }

    @Override
    public CountryDto getById(Long id) {
        Optional<Country> countryOpt = countryRepository.findById(id);
        if (countryOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return countryBuilder.build(countryOpt.get());
    }

    @Override
    public void update(Long id, CreateCountryDto request) {
        Optional<Country> countryOpt = countryRepository.findById(id);
        if (countryOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Country updateCountry = countryOpt.get();
        countryBuilder.update(updateCountry, request);
        countryRepository.save(updateCountry);
    }

    @Override
    public void deleteById(Long id) {
        Optional<Country> countryOpt = countryRepository.findById(id);
        if (countryOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        countryRepository.deleteById(id);
    }
}
