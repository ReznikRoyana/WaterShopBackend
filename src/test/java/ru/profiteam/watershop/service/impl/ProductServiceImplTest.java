package ru.profiteam.watershop.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.profiteam.watershop.builder.ManufacturerBuilderTest;
import ru.profiteam.watershop.builder.ProductBuilderTest;
import ru.profiteam.watershop.builder.SellerBuilderTest;
import ru.profiteam.watershop.domain.Manufacturer;
import ru.profiteam.watershop.domain.Product;
import ru.profiteam.watershop.domain.Seller;
import ru.profiteam.watershop.dto.request.CreateProductDto;
import ru.profiteam.watershop.dto.response.ProductDto;
import ru.profiteam.watershop.repository.ManufacturerRepository;
import ru.profiteam.watershop.repository.ProductRepository;
import ru.profiteam.watershop.repository.SellerRepository;
import ru.profiteam.watershop.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@RunWith(MockitoJUnitRunner.class)
class ProductServiceImplTest {
    @MockBean
    private SellerRepository sellerRepository;
    @MockBean
    private ManufacturerRepository manufacturerRepository;
    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private ProductBuilderTest productBuilderTest;
    @Autowired
    private SellerBuilderTest sellerBuilderTest;
    @Autowired
    private ManufacturerBuilderTest manufacturerBuilderTest;
    @Autowired
    private ProductService productService;

    @Test
    void create() {
        Seller sellerModel = sellerBuilderTest.build();
        Mockito.when(sellerRepository
                        .findById(sellerModel.getId()))
                .thenReturn(Optional.of(sellerModel));

        Manufacturer manufacturerModel = manufacturerBuilderTest.build();
        Mockito.when(manufacturerRepository
                        .findById(manufacturerModel.getId()))
                .thenReturn(Optional.of(manufacturerModel));

        Product productModel = productBuilderTest.build();
        Mockito.when(productRepository
                        .save(Mockito.any(Product.class)))
                .thenAnswer(i -> i.getArguments()[0]);

        CreateProductDto createProductDto = createCreateProductDto(productModel);
        productService.create(createProductDto);
    }


    @Test
    void getAll() {
        List<Product> productList = createProductList();
        Mockito.when(productRepository
                        .findAll())
                .thenReturn(productList);

        List<ProductDto> result = productService.getAll();
        assertEquals(result.get(0).getId(), 2L);
        assertEquals(result.get(1).getId(), 2L);
    }

    @Test
    void getById() {
        Product productModel = productBuilderTest.build();
        Mockito.when(productRepository
                        .findById(productModel.getId()))
                .thenReturn(Optional.of(productModel));

        assertEquals(productService.getById(productModel.getId()).getId(), 2L);
    }

    @Test
    void update() {
        Product productModel = productBuilderTest.build();
        Mockito.when(productRepository
                        .findById(productModel.getId()))
                .thenReturn(Optional.of(productModel));

        Seller sellerModel = sellerBuilderTest.build();
        Mockito.when(sellerRepository
                        .findById(sellerModel.getId()))
                .thenReturn(Optional.of(sellerModel));

        Manufacturer manufacturerModel = manufacturerBuilderTest.build();
        Mockito.when(manufacturerRepository
                        .findById(manufacturerModel.getId()))
                .thenReturn(Optional.of(manufacturerModel));

        Mockito.when(productRepository
                        .save(Mockito.any(Product.class)))
                .thenAnswer(i -> i.getArguments()[0]);

        CreateProductDto createProductDto = createCreateProductDto(productModel);
        productService.update(productModel.getId(), createProductDto);
    }

    @Test
    void deleteById() {
        Product productModel = productBuilderTest.build();
        Mockito.when(productRepository
                        .findById(productModel.getId()))
                .thenReturn(Optional.of(productModel));

        productService.deleteById(productModel.getId());
    }

    @Test
    void filter() {
        List<Product> productList = createProductList();
        Mockito.when(productRepository
                        .filter(null, null, null, null, null, null))
                .thenReturn(productList);

        List<ProductDto> result = productService.filter(null, null, null, null, null, null);
        assertEquals(result.get(0).getId(), 2L);
    }

    private List<Product> createProductList() {
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            productList.add(productBuilderTest.build());
        }
        return productList;
    }

    private CreateProductDto createCreateProductDto(Product product) {
        CreateProductDto createProductDto = new CreateProductDto();
        createProductDto.setSellerId(product.getId());
        createProductDto.setManufactureId(product.getId());
        createProductDto.setName(product.getName());
        createProductDto.setProductType(product.getProductType());
        createProductDto.setProductContainerMaterialType(product.getProductContainerMaterialType());
        createProductDto.setPrice(product.getPrice());
        createProductDto.setVolume(product.getVolume());
        return createProductDto;
    }
}
