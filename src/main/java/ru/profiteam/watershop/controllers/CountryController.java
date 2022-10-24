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
import ru.profiteam.watershop.dto.request.CreateCountryDto;
import ru.profiteam.watershop.dto.response.CountryDto;
import ru.profiteam.watershop.service.CountryService;
import ru.profiteam.watershop.utils.ErrorSwaggerModel;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RestController
@RequestMapping("country")
@Tag(name = "Country")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CountryController extends AuthorizationController {

    CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService, HttpServletRequest request) {
        super(request);
        this.countryService = countryService;
    }

    @BaseApiResponseEmpty
    @PostMapping
    public void create(@RequestBody CreateCountryDto request) {
        countryService.create(request);
    }

    @BaseApiResponse
    @GetMapping
    public List<CountryDto> getAll() {
        return countryService.getAll();
    }

    @BaseApiResponse
    @GetMapping("/{id}")
    public CountryDto getById(@PathVariable Long id) {
        return countryService.getById(id);
    }

    @BaseApiResponseEmpty
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody CreateCountryDto request) {
        countryService.update(id, request);
    }

    @BaseApiResponseEmpty
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        countryService.deleteById(id);
    }

}
