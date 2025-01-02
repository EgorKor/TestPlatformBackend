package ru.korovin.TestPlatform.service;

import ru.korovin.TestPlatform.domain.dto.creation.TaskCreationDto;
import ru.korovin.TestPlatform.domain.model.test.Task;
import ru.korovin.TestPlatform.domain.model.test.Test;

import java.util.List;

public interface TaskService {

    List<Task> save(List<TaskCreationDto> tasks, Test test);



}
