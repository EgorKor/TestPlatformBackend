package ru.korovin.TestPlatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.korovin.TestPlatform.domain.model.test.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
