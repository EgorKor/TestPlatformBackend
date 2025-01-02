package ru.korovin.TestPlatform.repository.subject;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.korovin.TestPlatform.domain.model.test.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
