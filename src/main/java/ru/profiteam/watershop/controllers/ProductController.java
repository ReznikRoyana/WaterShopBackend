package ru.profiteam.watershop.controllers;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
import ru.profiteam.watershop.dto.request.CreateProductDto;
import ru.profiteam.watershop.dto.response.ProductDto;
import ru.profiteam.watershop.service.ProductService;
import ru.profiteam.watershop.utils.ErrorSwaggerModel;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RestController
@RequestMapping("product")
@Tag(name = "Product")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductController extends AuthorizationController {
    ProductService productService;


    @Autowired
    public ProductController(ProductService productService, HttpServletRequest request) {
        super(request);
        this.productService = productService;
    }

    @BaseApiResponseEmpty
    @PostMapping
    public void create(@RequestBody CreateProductDto request) {
        productService.create(request);
    }

    @BaseApiResponse
    @GetMapping
    public List<ProductDto> getAll() {
        return productService.getAll();
    }

    @BaseApiResponseEmpty
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody CreateProductDto request) {
        productService.update(id, request);
    }

    @BaseApiResponseEmpty
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @BaseApiResponse
    @GetMapping("filter")
    public List<ProductDto> filter(@RequestParam(required = false) List<Long> manufacturersIds,
                                   @RequestParam(required = false) Integer minPrice,
                                   @RequestParam(required = false) Integer maxPrice,
                                   @RequestParam(required = false) List<Long> sellersIds,
                                   @RequestParam(required = false) Float minVolume,
                                   @RequestParam(required = false) Float maxVolume) {
        return productService.filter(manufacturersIds, minPrice, maxPrice, sellersIds, minVolume, maxVolume);
    }

}
