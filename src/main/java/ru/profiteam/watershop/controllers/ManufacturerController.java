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
import ru.profiteam.watershop.dto.request.CreateManufacturerDto;
import ru.profiteam.watershop.dto.response.ManufacturerDto;
import ru.profiteam.watershop.service.ManufacturerService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RequestMapping("manufacturer")
@Tag(name = "Manufacturer")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ManufacturerController extends AuthorizationController {

    ManufacturerService manufacturerService;

    @Autowired
    public ManufacturerController(ManufacturerService manufacturerService, HttpServletRequest request) {
        super(request);
        this.manufacturerService = manufacturerService;
    }

    @BaseApiResponseEmpty
    @PostMapping
    public void create(@RequestBody CreateManufacturerDto request) {
        manufacturerService.create(request);
    }

    @BaseApiResponse
    @GetMapping
    public List<ManufacturerDto> getAll() {
        return manufacturerService.getAll();
    }

    @BaseApiResponse
    @GetMapping("/{id}")
    public ManufacturerDto getById(@PathVariable Long id) {
        return manufacturerService.getById(id);
    }

    @BaseApiResponseEmpty
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody CreateManufacturerDto request) {
        manufacturerService.update(id, request);
    }

    @BaseApiResponseEmpty
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        manufacturerService.deleteById(id);
    }
}
