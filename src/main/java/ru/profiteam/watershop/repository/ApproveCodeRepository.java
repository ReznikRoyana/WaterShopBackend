package ru.profiteam.watershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.profiteam.watershop.domain.ApproveCode;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
public interface ApproveCodeRepository extends JpaRepository<ApproveCode, Long> {

    Optional<ApproveCode> findByNumberAndCode(String number, String code);

    Optional<ApproveCode> findFirstByNumber(String number);
}

