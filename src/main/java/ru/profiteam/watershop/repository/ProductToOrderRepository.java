package ru.profiteam.watershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.profiteam.watershop.domain.ProductToOrder;

@Repository
public interface ProductToOrderRepository extends JpaRepository<ProductToOrder, Long> {

}
