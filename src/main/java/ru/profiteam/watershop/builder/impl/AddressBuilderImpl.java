package ru.profiteam.watershop.builder.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.profiteam.watershop.builder.AddressBuilder;
import ru.profiteam.watershop.builder.CityBuilder;
import ru.profiteam.watershop.domain.Address;
import ru.profiteam.watershop.domain.City;
import ru.profiteam.watershop.domain.User;
import ru.profiteam.watershop.dto.request.CreateAddressDto;
import ru.profiteam.watershop.dto.response.AddressDto;

import java.util.Date;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AddressBuilderImpl implements AddressBuilder {

    CityBuilder cityBuilder;

    @Override
    public AddressDto build(Address address) {
        return AddressDto.builder()
                .id(address.getId())
                .latitude(address.getLatitude())
                .longitude(address.getLongitude())
                .city(cityBuilder.build(address.getCity()))
                .street(address.getStreet())
                .house(address.getHouse())
                .flat(address.getFlat())
                .level(address.getLevel())
                .elevator(address.isElevator())
                .build();
    }

    @Override
    public Address build(CreateAddressDto request,
                         User user,
                         City city) {
        Address address = new Address();
        address.setLatitude(request.getLatitude());
        address.setLongitude(request.getLongitude());
        address.setCity(city);
        address.setStreet(request.getStreet());
        address.setHouse(request.getHouse());
        address.setFlat(request.getFlat());
        address.setLevel(request.getLevel());
        address.setElevator(request.isElevator());
        address.setUser(user);
        address.setCreatedAt(new Date());
        return address;
    }

    @Override
    public void update(Address address,
                       CreateAddressDto request,
                       User user,
                       City city) {
        address.setLatitude(request.getLatitude());
        address.setLongitude(request.getLongitude());
        address.setCity(city);
        address.setStreet(request.getStreet());
        address.setHouse(request.getHouse());
        address.setFlat(request.getFlat());
        address.setLevel(request.getLevel());
        address.setElevator(request.isElevator());
        address.setUser(user);
        address.setUpdatedAt(new Date());
    }
}
