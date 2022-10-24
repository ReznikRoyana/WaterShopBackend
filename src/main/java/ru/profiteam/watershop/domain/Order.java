package ru.profiteam.watershop.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import ru.profiteam.watershop.domain.base.PersistentObject;
import ru.profiteam.watershop.domain.enums.PayMethodType;

import javax.persistence.*;
import java.util.List;

//заказы
@Getter
@Setter
@Entity
@Table(name = "orders")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order extends PersistentObject {

    @Column(name = "name")
    String name;

    @Column(name = "address")
    String address;

    @Column(name = "phoneNumber")
    String phoneNumber;

    @Column(name = "context_type")
    @Enumerated(EnumType.STRING)
    PayMethodType payMethodType;

    @OneToMany(mappedBy = "product")
    List<ProductToOrder> productsToOrders;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

}
