package ru.korovin.TestPlatform.domain.dto.sample;

import ru.korovin.TestPlatform.domain.dto.creation.AnswerCreationDto;

import java.util.List;

public class TaskDtoWithAnswers {
    private Long id;
    private String task;
    private List<AnswerCreationDto> answerCreationDtos;


}
