package ru.profiteam.watershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.profiteam.watershop.domain.Country;
import ru.profiteam.watershop.domain.DeliveryServiceMassage;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
