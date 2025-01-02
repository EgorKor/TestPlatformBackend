package ru.korovin.TestPlatform.domain.util.converter;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.korovin.TestPlatform.domain.dto.creation.TaskCreationDto;
import ru.korovin.TestPlatform.domain.model.test.Task;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TaskDtoConverter {
    private final ModelMapper modelMapper;

    public List<Task> toModel(List<TaskCreationDto> dtos){
        List<Task> tasks = new ArrayList<>();
        for(TaskCreationDto dto: dtos){
            Task task = modelMapper.map(dto, Task.class);
            tasks.add(task);
        }
        return tasks;
    }
}
