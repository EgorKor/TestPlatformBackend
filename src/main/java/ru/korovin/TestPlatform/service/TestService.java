package ru.korovin.TestPlatform.service;

import org.springframework.transaction.annotation.Transactional;
import ru.korovin.TestPlatform.domain.dto.creation.TestCreationDto;
import ru.korovin.TestPlatform.domain.model.test.Test;

import java.util.List;

public interface TestService {
    @Transactional
    Test save(Test test);

    @Transactional(readOnly = true)
    List<Test> getAll();

    @Transactional(readOnly = true)
    Test getById(Long id);

    @Transactional
    void delete(Long id);
}
