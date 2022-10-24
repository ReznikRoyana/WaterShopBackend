package ru.profiteam.watershop.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import ru.profiteam.watershop.domain.base.PersistentObject;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "product_to_order")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductToOrder extends PersistentObject {

    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;

    @ManyToOne
    @JoinColumn(name = "order_id")
    Order order;

    @Column(name = "count")
    int count;

}
