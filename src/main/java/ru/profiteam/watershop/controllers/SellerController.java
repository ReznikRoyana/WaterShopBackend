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
import ru.profiteam.watershop.dto.request.CreateSellerDto;
import ru.profiteam.watershop.dto.response.SellerDto;
import ru.profiteam.watershop.service.SellerService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RestController
@RequestMapping("seller")
@Tag(name = "Seller")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class SellerController extends AuthorizationController {
    SellerService sellerService;

    @Autowired
    public SellerController(SellerService sellerService, HttpServletRequest request) {
        super(request);
        this.sellerService = sellerService;
    }

    @BaseApiResponseEmpty
    @PostMapping
    public void create(@RequestBody CreateSellerDto request) {
        sellerService.create(request);
    }

    @BaseApiResponse
    @GetMapping
    public List<SellerDto> getAll() {
        return sellerService.getAll();
    }

    @BaseApiResponseEmpty
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        sellerService.deleteById(id);
    }

    @BaseApiResponse
    @GetMapping("/{id}")
    public SellerDto getById(@PathVariable Long id) {
        return sellerService.getById(id);
    }
}
