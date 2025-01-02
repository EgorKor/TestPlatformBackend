package ru.korovin.TestPlatform.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.korovin.TestPlatform.domain.dto.creation.AnswerCreationDto;
import ru.korovin.TestPlatform.domain.model.test.Answer;
import ru.korovin.TestPlatform.domain.model.test.Task;
import ru.korovin.TestPlatform.domain.util.converter.AnswerDtoConverter;
import ru.korovin.TestPlatform.repository.AnswerRepository;
import ru.korovin.TestPlatform.service.AnswerService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {
    private final AnswerRepository answerRepository;
    private final AnswerDtoConverter answerDtoConverter;

    @Override
    @Transactional
    public List<Answer> save(List<AnswerCreationDto> answers, Task task) {
        List<Answer> answersToSave = answerDtoConverter.toModel(answers);
        answersToSave.forEach(o -> o.setTask(task));
        return answerRepository.saveAll(answersToSave);
    }
}
