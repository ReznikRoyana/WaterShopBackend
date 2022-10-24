package ru.profiteam.watershop.service.impl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.profiteam.watershop.builder.ManufacturerBuilder;
import ru.profiteam.watershop.domain.Manufacturer;
import ru.profiteam.watershop.dto.request.CreateManufacturerDto;
import ru.profiteam.watershop.dto.response.ManufacturerDto;
import ru.profiteam.watershop.repository.ManufacturerRepository;
import ru.profiteam.watershop.service.ManufacturerService;

import java.util.*;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class ManufacturerServiceImpl implements ManufacturerService {
    ManufacturerRepository manufacturerRepository;
    ManufacturerBuilder manufacturerBuilder;

    @Autowired
    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository, ManufacturerBuilder manufacturerBuilder) {
        this.manufacturerRepository = manufacturerRepository;
        this.manufacturerBuilder = manufacturerBuilder;
    }

    @Override
    public void create(CreateManufacturerDto request){
        Manufacturer manufacturer = manufacturerBuilder.build(request);
        manufacturerRepository.save(manufacturer);
    }

    @Override
    public List<ManufacturerDto> getAll() {
        List<Manufacturer> manufacturerList = manufacturerRepository.findAll();
        List<ManufacturerDto> manufacturerDtoList = new ArrayList<>();
        for(Manufacturer item: manufacturerList){
            manufacturerDtoList.add(manufacturerBuilder.build(item));
        }
        return manufacturerDtoList;
    }

    @Override
    public ManufacturerDto getById(Long id) {
        Optional<Manufacturer> manufacturerOpt = manufacturerRepository.findById(id);
        if (manufacturerOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return manufacturerBuilder.build(manufacturerOpt.get());
    }

    @Override
    public void update(Long id, CreateManufacturerDto request) {
        Optional<Manufacturer> manufacturerOpt = manufacturerRepository.findById(id);
        if (manufacturerOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Manufacturer updateManufacturer = manufacturerOpt.get();
        manufacturerBuilder.update(updateManufacturer, request);
        manufacturerRepository.save(updateManufacturer);
    }

    @Override
    public void deleteById(Long id) {
        Optional<Manufacturer> manufacturerOpt = manufacturerRepository.findById(id);
        if (manufacturerOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        manufacturerRepository.deleteById(id);
    }
}
