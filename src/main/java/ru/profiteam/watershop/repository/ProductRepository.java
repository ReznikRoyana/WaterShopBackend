package ru.profiteam.watershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.profiteam.watershop.domain.Product;
import ru.profiteam.watershop.domain.enums.ProductType;
import ru.profiteam.watershop.dto.response.ProductDto;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByNameLike(String name);

//    @Query("SELECT p FROM Product p WHERE (:name is null OR p.name LIKE %:name%)")
//    List<Product> getAllFilter(@Param("name") String name);

    @Query("SELECT product FROM Product product " +
            "WHERE ((:manufacturersIds) is null OR product.manufacturer.id IN (:manufacturersIds)) " +
            "AND ((:sellersIds) is null OR product.seller.id IN (:sellersIds)) " +
            "AND (:minPrice is null OR product.price >= :minPrice) " +
            "AND (:maxPrice is null OR product.price <= :maxPrice) " +
            "AND (:minVolume is null OR product.volume >= :minVolume) " +
            "AND (:maxVolume is null OR product.volume <= :maxVolume) " +
            "AND product.deletedAt is null " )
    List<Product> filter(@Param("manufacturersIds") List<Long> manufacturersIds,
                         @Param("minPrice") Integer minPrice,
                         @Param("maxPrice") Integer maxPrice,
                         @Param("sellersIds") List<Long> sellersIds,
                         @Param("minVolume") Float minVolume,
                         @Param("maxVolume") Float maxVolume);
}
