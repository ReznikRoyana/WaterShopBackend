package ru.profiteam.watershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.profiteam.watershop.domain.ApproveCode;
import ru.profiteam.watershop.domain.GroceryBasket;

@Repository
public interface GroceryBasketRepository extends JpaRepository<GroceryBasket, Long> {
}
