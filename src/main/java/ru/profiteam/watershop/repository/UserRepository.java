package ru.profiteam.watershop.repository;

import jdk.dynalink.linker.LinkerServices;
import liquibase.pro.packaged.L;
import liquibase.pro.packaged.P;
import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.profiteam.watershop.domain.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findFirstByLogin(String login);

//    @Query("SELECT users FROM Users users " +
//            "WHERE (:login is null OR users.login = :login) " )
//    List<User> findAllByLogin(@Param("login") String login);

}
