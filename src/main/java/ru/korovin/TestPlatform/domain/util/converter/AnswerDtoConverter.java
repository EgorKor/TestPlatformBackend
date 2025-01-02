package ru.korovin.TestPlatform.domain.util.converter;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.korovin.TestPlatform.domain.dto.creation.AnswerCreationDto;
import ru.korovin.TestPlatform.domain.model.test.Answer;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AnswerDtoConverter {
    private final ModelMapper modelMapper;

    public List<Answer> toModel(List<AnswerCreationDto> dtos){
        List<Answer> answers = new ArrayList<>();
        for(AnswerCreationDto dto: dtos){
            answers.add(modelMapper.map(dto, Answer.class));
        }
        return answers;
    }
}
