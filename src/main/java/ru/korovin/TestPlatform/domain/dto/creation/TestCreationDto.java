package ru.korovin.TestPlatform.domain.dto.creation;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TestCreationDto {
    private String name;
    private List<TaskCreationDto> tasks;
    private Long subjectId;
}
