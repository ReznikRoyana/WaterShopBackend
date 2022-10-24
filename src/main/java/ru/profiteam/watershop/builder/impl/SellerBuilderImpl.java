package ru.profiteam.watershop.builder.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.profiteam.watershop.builder.SellerBuilder;
import ru.profiteam.watershop.builder.UserBuilder;
import ru.profiteam.watershop.domain.Seller;
import ru.profiteam.watershop.domain.User;
import ru.profiteam.watershop.dto.request.CreateSellerDto;
import ru.profiteam.watershop.dto.response.SellerDto;

import java.util.Date;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class SellerBuilderImpl implements SellerBuilder {


    @Override
    public Seller build() {
        return new Seller();
    }

    @Override
    public SellerDto build(Seller seller) {
        return SellerDto.builder()
                .id(seller.getId())
                .name(seller.getName())
                .bik(seller.getBik())
                .inn(seller.getInn())
                .description(seller.getDescription())
                .build();
    }

    @Override
    public Seller build(CreateSellerDto request) {
        Seller seller = new Seller();
        seller.setName(request.getName());
        seller.setInn(request.getInn());
        seller.setBik(request.getBik());
        seller.setDescription(request.getDescription());
        seller.setCreatedAt(new Date());
        return seller;
    }

    @Override
    public void update(Seller seller, CreateSellerDto request) {
        seller.setName(request.getName());
        seller.setInn(request.getInn());
        seller.setBik(request.getBik());
        seller.setDescription(request.getDescription());
        seller.setUpdatedAt(new Date());
    }
}
