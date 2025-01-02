package ru.korovin.TestPlatform.repository;

import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.korovin.TestPlatform.domain.model.test.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
