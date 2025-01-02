package ru.korovin.TestPlatform.domain.util.converter;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.korovin.TestPlatform.domain.dto.creation.SubjectCreationDto;
import ru.korovin.TestPlatform.domain.dto.sample.SubjectDto;
import ru.korovin.TestPlatform.domain.model.test.Subject;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SubjectDtoConverter {
    private final ModelMapper modelMapper;

    public Subject toModel(SubjectCreationDto dto){
        return modelMapper.map(dto, Subject.class);
    }

    public Subject toModel(SubjectDto dto){
        return modelMapper.map(dto, Subject.class);
    }

    public List<SubjectDto> toDto(List<Subject> subjects){
        List<SubjectDto> subjectDto = new ArrayList<>();
        for(Subject subject: subjects){
            SubjectDto dto = modelMapper.map(subject, SubjectDto.class);
            subjectDto.add(dto);
        }
        return subjectDto;
    }





}
