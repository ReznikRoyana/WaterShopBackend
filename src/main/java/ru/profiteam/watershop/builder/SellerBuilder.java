package ru.profiteam.watershop.builder;

import ru.profiteam.watershop.domain.Seller;
import ru.profiteam.watershop.domain.User;
import ru.profiteam.watershop.dto.request.CreateSellerDto;
import ru.profiteam.watershop.dto.response.SellerDto;

public interface SellerBuilder {
    Seller build();

    SellerDto build(Seller seller);

    Seller build(CreateSellerDto request);

    void update(Seller seller, CreateSellerDto request);
}
