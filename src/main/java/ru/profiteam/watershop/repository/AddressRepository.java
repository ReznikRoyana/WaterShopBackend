package ru.profiteam.watershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.profiteam.watershop.domain.Address;

import java.util.stream.Stream;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

//    @Query("")
//    Stream<Address> findAllByUUID();
}
