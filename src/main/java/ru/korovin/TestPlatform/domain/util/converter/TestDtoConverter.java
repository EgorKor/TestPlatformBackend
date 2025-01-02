package ru.korovin.TestPlatform.domain.util.converter;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.korovin.TestPlatform.domain.dto.sample.TestDto;
import ru.korovin.TestPlatform.domain.dto.sample.TestDtoWithTasks;
import ru.korovin.TestPlatform.domain.model.test.Test;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TestDtoConverter {
    private final ModelMapper modelMapper;

    public List<TestDto> toDto(List<Test> model){
        List<TestDto> tests = new ArrayList<>();
        model.forEach(o -> tests.add(modelMapper.map(o, TestDto.class)));
        return tests;
    }

    public TestDtoWithTasks toDto(Test test){
        return modelMapper.map(test, TestDtoWithTasks.class);
    }
}
