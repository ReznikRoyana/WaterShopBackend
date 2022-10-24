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
import ru.profiteam.watershop.dto.request.CreateCityDto;
import ru.profiteam.watershop.dto.response.CityDto;
import ru.profiteam.watershop.service.CityService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RestController
@RequestMapping("city")
@Tag(name = "City")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CityController extends AuthorizationController {
    CityService cityService;

    @Autowired
    public CityController(CityService cityService, HttpServletRequest request) {
        super(request);
        this.cityService = cityService;
    }

    @BaseApiResponseEmpty
    @PostMapping
    public void create(@RequestBody CreateCityDto request) {
        cityService.create(request);
    }

    @BaseApiResponse
    @GetMapping
    public List<CityDto> getAll() {
        return cityService.getAll();
    }

    @BaseApiResponse
    @GetMapping("/{id}")
    public CityDto getById(@PathVariable(name = "id") Long id) {
        return cityService.getById(id);
    }

    @BaseApiResponseEmpty
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody CreateCityDto request) {
        cityService.update(id, request);
    }

    @BaseApiResponseEmpty
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        cityService.deleteById(id);
    }
}
