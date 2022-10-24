package ru.profiteam.watershop.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;
import ru.profiteam.watershop.annotation.BaseApiResponse;
import ru.profiteam.watershop.annotation.BaseApiResponseEmpty;
import ru.profiteam.watershop.controllers.base.AuthorizationController;
import ru.profiteam.watershop.dto.request.CreateGroceryBasketDto;
import ru.profiteam.watershop.dto.response.GroceryBasketDto;
import ru.profiteam.watershop.service.GroceryBasketService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RestController
@RequestMapping("grocery_basket")
@Tag(name = "Grocery_basket")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GroceryBasketController extends AuthorizationController {
    GroceryBasketService groceryBasketService;

    @Autowired
    public GroceryBasketController(GroceryBasketService groceryBasketService, HttpServletRequest request) {
        super(request);
        this.groceryBasketService = groceryBasketService;
    }

    @BaseApiResponseEmpty
    @PostMapping
    public void create(@RequestBody CreateGroceryBasketDto request) {
        groceryBasketService.create(request);
    }

    @BaseApiResponse
    @GetMapping()
    public List<GroceryBasketDto> getAll() {
        return groceryBasketService.getAll();
    }

    @BaseApiResponse
    @GetMapping("/{id}")
    public GroceryBasketDto getById(@PathVariable Long id) {
        return groceryBasketService.getById(id);
    }

    @BaseApiResponseEmpty
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody GroceryBasketDto request) {
        groceryBasketService.update(id, request);
    }

    @BaseApiResponseEmpty
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        groceryBasketService.deleteById(id);
    }
}
