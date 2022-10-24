package ru.profiteam.watershop.builder.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.profiteam.watershop.builder.ManufacturerBuilderTest;
import ru.profiteam.watershop.domain.Manufacturer;

import java.util.Date;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ManufacturerBuilderTestImpl implements ManufacturerBuilderTest {
    @Override
    public Manufacturer build() {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setId(2L);
        manufacturer.setCreatedAt(new Date());
        manufacturer.setLogo("logo");
        manufacturer.setName("name");
        manufacturer.setSum("sum");
        return manufacturer;
    }
}
