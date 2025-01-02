package ru.korovin.TestPlatform.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.korovin.TestPlatform.domain.dto.creation.TaskCreationDto;
import ru.korovin.TestPlatform.domain.model.test.Task;
import ru.korovin.TestPlatform.domain.model.test.Test;
import ru.korovin.TestPlatform.domain.util.converter.TaskDtoConverter;
import ru.korovin.TestPlatform.repository.TaskRepository;
import ru.korovin.TestPlatform.service.AnswerService;
import ru.korovin.TestPlatform.service.TaskService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskDtoConverter taskDtoConverter;
    private final TaskRepository taskRepository;

    @Override
    @Transactional
    public List<Task> save(List<TaskCreationDto> tasks, Test test) {
        List<Task> tasksToSave = taskDtoConverter.toModel(tasks);
        tasksToSave.forEach(o -> {
            o.setTest(test);
            o.setAnswers(null);
        });
        return taskRepository.saveAll(tasksToSave);
    }
}
