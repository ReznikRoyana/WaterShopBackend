package ru.profiteam.watershop.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.profiteam.watershop.builder.GroceryBasketBuilder;
import ru.profiteam.watershop.builder.UserBuilder;
import ru.profiteam.watershop.domain.GroceryBasket;
import ru.profiteam.watershop.domain.Product;
import ru.profiteam.watershop.domain.User;
import ru.profiteam.watershop.dto.request.CreateGroceryBasketDto;
import ru.profiteam.watershop.dto.response.GroceryBasketDto;
import ru.profiteam.watershop.repository.GroceryBasketRepository;
import ru.profiteam.watershop.repository.ProductRepository;
import ru.profiteam.watershop.repository.UserRepository;
import ru.profiteam.watershop.service.GroceryBasketService;

import java.util.List;
import java.util.Optional;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class GroceryBasketServiceImpl implements GroceryBasketService {
    GroceryBasketRepository groceryBasketRepository;
    GroceryBasketBuilder groceryBasketBuilder;
    UserRepository userRepository;
    ProductRepository productRepository;

    @Override
    public void create(CreateGroceryBasketDto request) {
        Optional<User> userOpt = userRepository.findById(request.getUserId());
        if (userOpt.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Optional<Product> productOpt = productRepository.findById(request.getProductId());
        if (productOpt.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        GroceryBasket groceryBasket = groceryBasketBuilder.build(productOpt.get(), userOpt.get());
        groceryBasketRepository.save(groceryBasket);
    }

    @Override
    public List<GroceryBasketDto> getAll() {
        return null;
    }

    @Override
    public GroceryBasketDto getById(Long id) {
        return null;
    }

    @Override
    public void update(Long id, GroceryBasketDto request) {
    }

    @Override
    public void deleteById(Long id) {

    }
}
