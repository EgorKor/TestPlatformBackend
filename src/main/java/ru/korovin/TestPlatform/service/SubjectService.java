package ru.korovin.TestPlatform.service;

import ru.korovin.TestPlatform.domain.model.test.Subject;
import ru.korovin.TestPlatform.domain.util.converter.SubjectDtoConverter;

import java.util.List;

public interface SubjectService {

    Subject save(Subject subject);
    Subject update(Subject subject);
    Subject getById(Long id);
    List<Subject> getAll();
    void delete(Long id);


}
