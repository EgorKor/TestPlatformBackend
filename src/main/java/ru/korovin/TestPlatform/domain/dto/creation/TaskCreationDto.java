package ru.korovin.TestPlatform.domain.dto.creation;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class TaskCreationDto {
    private String task;
    private List<AnswerCreationDto> answers;
}
