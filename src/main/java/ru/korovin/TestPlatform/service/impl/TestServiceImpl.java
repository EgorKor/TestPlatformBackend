package ru.korovin.TestPlatform.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.korovin.TestPlatform.domain.exception.ResourceNotFoundException;
import ru.korovin.TestPlatform.domain.model.test.Test;
import ru.korovin.TestPlatform.repository.TestRepository;
import ru.korovin.TestPlatform.service.SubjectService;
import ru.korovin.TestPlatform.service.TaskService;
import ru.korovin.TestPlatform.service.TestService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {
    private final TestRepository testRepository;
    private final TaskService taskService;
    private final SubjectService subjectService;

    @Override
    @Transactional
    public Test save(Test test) {
        return testRepository.save(test);
    }

    @Override
    public List<Test> getAll() {
        return testRepository.findAll();
    }

    @Override
    public Test getById(Long id) {
        return testRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public void delete(Long id) {
        testRepository.deleteById(id);
    }

}
