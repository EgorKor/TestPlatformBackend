package ru.korovin.TestPlatform.service;

import ru.korovin.TestPlatform.domain.dto.creation.AnswerCreationDto;
import ru.korovin.TestPlatform.domain.model.test.Answer;
import ru.korovin.TestPlatform.domain.model.test.Task;

import java.util.List;

public interface AnswerService {

    List<Answer> save(List<AnswerCreationDto> answers, Task task);
}
