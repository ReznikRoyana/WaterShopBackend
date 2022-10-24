package ru.profiteam.watershop.builder;

import ru.profiteam.watershop.domain.Manufacturer;
import ru.profiteam.watershop.dto.request.CreateManufacturerDto;
import ru.profiteam.watershop.dto.response.ManufacturerDto;

public interface ManufacturerBuilder {

    ManufacturerDto build(Manufacturer manufacturer);

    Manufacturer build(CreateManufacturerDto request);

    void update(Manufacturer manufacturer, CreateManufacturerDto request);
}
