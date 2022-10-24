package ru.profiteam.watershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.profiteam.watershop.domain.Session;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
}
