package ru.profiteam.watershop.builder.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.profiteam.watershop.builder.SellerBuilder;
import ru.profiteam.watershop.builder.SellerToUserBuilder;
import ru.profiteam.watershop.builder.UserBuilder;
import ru.profiteam.watershop.domain.Seller;
import ru.profiteam.watershop.domain.SellerToUser;
import ru.profiteam.watershop.domain.User;
import ru.profiteam.watershop.dto.request.CreateSellerToUserDto;
import ru.profiteam.watershop.dto.response.SellerToUserDto;

import java.util.Date;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class SellerToUserBuilderImpl implements SellerToUserBuilder {

    SellerBuilder sellerBuilder;
    UserBuilder userBuilder;

    @Override
    public SellerToUserDto build(SellerToUser sellerToUser) {
        return SellerToUserDto.builder()
                .id(sellerToUser.getId())
                .seller(sellerBuilder.build(sellerToUser.getSeller()))
                .user(userBuilder.build(sellerToUser.getUser()))
                .build();
    }

    @Override
    public SellerToUser build(CreateSellerToUserDto request, Seller seller, User user) {
        SellerToUser sellerToUser = new SellerToUser();
        sellerToUser.setSeller(seller);
        sellerToUser.setUser(user);
        sellerToUser.setCreatedAt(new Date());
        return sellerToUser;
    }

    @Override
    public void update(SellerToUser sellerToUser, CreateSellerToUserDto request, Seller seller, User user) {
        sellerToUser.setSeller(seller);
        sellerToUser.setUser(user);
        sellerToUser.setUpdatedAt(new Date());
    }
}
