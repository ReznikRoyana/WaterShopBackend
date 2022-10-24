package ru.profiteam.watershop.builder;

import ru.profiteam.watershop.domain.Address;
import ru.profiteam.watershop.domain.City;
import ru.profiteam.watershop.domain.User;
import ru.profiteam.watershop.dto.request.CreateAddressDto;
import ru.profiteam.watershop.dto.response.AddressDto;

public interface AddressBuilder {

    AddressDto build(Address address);

    Address build(CreateAddressDto request, User user, City city);

    void update(Address address, CreateAddressDto request, User user, City city);

}
