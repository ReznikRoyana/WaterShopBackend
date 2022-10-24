package ru.profiteam.watershop.builder;

import ru.profiteam.watershop.domain.*;
import ru.profiteam.watershop.dto.request.CreateSellerToUserDto;
import ru.profiteam.watershop.dto.response.SellerToUserDto;

public interface SellerToUserBuilder {

    SellerToUserDto build(SellerToUser sellerToUser);

    SellerToUser build(CreateSellerToUserDto request,
                       Seller seller,
                       User user);

    void update(SellerToUser sellerToUser,
                CreateSellerToUserDto request,
                Seller seller,
                User user);
}
