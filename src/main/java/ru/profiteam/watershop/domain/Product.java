package ru.profiteam.watershop.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.profiteam.watershop.domain.base.PersistentObject;
import ru.profiteam.watershop.domain.enums.ProductContainerMaterialType;
import ru.profiteam.watershop.domain.enums.ProductType;
import ru.profiteam.watershop.dto.response.SellerDto;

import javax.persistence.*;
import java.util.List;

//продукт
@Getter
@Setter
@Entity
@Table(name = "product")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product extends PersistentObject {

    @Column(name = "name")
    String name;

    @Column(name = "product_type")
    @Enumerated(EnumType.STRING)
    ProductType productType;

    @Column(name = "product_container_material_type")
    @Enumerated(EnumType.STRING)
    ProductContainerMaterialType productContainerMaterialType;

    @Column(name = "price")
    Integer price;

    @Column(name = "volume")
    Float volume;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    Seller seller;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    Manufacturer manufacturer;

    @OneToMany(mappedBy = "product")
    List<ProductToOrder> productToOrders;
}
