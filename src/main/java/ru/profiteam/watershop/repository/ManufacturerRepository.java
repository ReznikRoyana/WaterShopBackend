package ru.profiteam.watershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.profiteam.watershop.domain.Manufacturer;
@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer,Long> {
}
