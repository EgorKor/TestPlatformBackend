package ru.korovin.TestPlatform.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.korovin.TestPlatform.domain.exception.ResourceNotFoundException;
import ru.korovin.TestPlatform.domain.model.test.Subject;
import ru.korovin.TestPlatform.repository.subject.SubjectRepository;
import ru.korovin.TestPlatform.service.SubjectService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository subjectRepository;


    @Override
    public Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public Subject update(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public Subject getById(Long id) {
        return subjectRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public List<Subject> getAll() {
        return subjectRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        subjectRepository.deleteById(id);
    }
}
