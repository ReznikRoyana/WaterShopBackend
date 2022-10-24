package ru.profiteam.watershop.builder.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.profiteam.watershop.builder.ManufacturerBuilder;
import ru.profiteam.watershop.domain.Manufacturer;
import ru.profiteam.watershop.dto.request.CreateManufacturerDto;
import ru.profiteam.watershop.dto.response.ManufacturerDto;

import java.util.Date;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ManufacturerBuilderImpl implements ManufacturerBuilder {

    @Override
    public ManufacturerDto build(Manufacturer manufacturer) {
        return ManufacturerDto.builder()
                .id(manufacturer.getId())
                .logo(manufacturer.getLogo())
                .name(manufacturer.getName())
                .build();
    }

    @Override
    public Manufacturer build(CreateManufacturerDto request) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setLogo(request.getLogo());
        manufacturer.setName(request.getName());
        manufacturer.setCreatedAt(new Date());
        return manufacturer;
    }

    @Override
    public void update(Manufacturer manufacturer, CreateManufacturerDto request) {
        manufacturer.setLogo(request.getLogo());
        manufacturer.setName(request.getName());
        manufacturer.setUpdatedAt(new Date());
    }
}
