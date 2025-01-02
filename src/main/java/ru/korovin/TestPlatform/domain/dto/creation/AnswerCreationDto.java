package ru.korovin.TestPlatform.domain.dto.creation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerCreationDto {
    private String answer;
    private boolean isCorrect;
}
