package ru.korovin.TestPlatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.korovin.TestPlatform.domain.model.test.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
}
