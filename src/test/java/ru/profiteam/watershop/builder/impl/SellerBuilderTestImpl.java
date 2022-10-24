package ru.profiteam.watershop.builder.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.profiteam.watershop.builder.SellerBuilderTest;
import ru.profiteam.watershop.domain.Seller;

import java.util.Date;
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class SellerBuilderTestImpl implements SellerBuilderTest {
    @Override
    public Seller build() {
        Seller seller = new Seller();
        seller.setId(2L);
        seller.setCreatedAt(new Date());
        seller.setBik("bik");
        seller.setDescription("description");
        seller.setInn("inn");
        seller.setName("name");
        return seller;
    }
}
