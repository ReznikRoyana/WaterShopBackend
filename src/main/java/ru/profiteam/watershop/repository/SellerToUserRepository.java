package ru.profiteam.watershop.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.profiteam.watershop.domain.SellerToUser;

@Repository
public interface SellerToUserRepository extends JpaRepository<SellerToUser, Long> {

}
