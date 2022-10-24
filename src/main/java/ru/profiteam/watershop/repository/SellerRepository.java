package ru.profiteam.watershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.profiteam.watershop.domain.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {
}
