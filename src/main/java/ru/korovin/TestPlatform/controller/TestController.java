package ru.korovin.TestPlatform.controller;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.korovin.TestPlatform.domain.dto.creation.TestCreationDto;
import ru.korovin.TestPlatform.domain.dto.sample.TestDto;
import ru.korovin.TestPlatform.domain.dto.sample.TestDtoWithTasks;
import ru.korovin.TestPlatform.domain.model.test.Task;
import ru.korovin.TestPlatform.domain.model.test.Test;
import ru.korovin.TestPlatform.domain.util.converter.TestDtoConverter;
import ru.korovin.TestPlatform.domain.util.security.SecurityUtils;
import ru.korovin.TestPlatform.service.AnswerService;
import ru.korovin.TestPlatform.service.SubjectService;
import ru.korovin.TestPlatform.service.TaskService;
import ru.korovin.TestPlatform.service.TestService;

import java.util.List;

@RequestMapping("/api/v1/tests")
@RequiredArgsConstructor
@RestController
public class TestController {
    private final SecurityUtils securityUtils;
    private final TestService testService;
    private final SubjectService subjectService;
    private final TaskService taskService;
    private final AnswerService answerService;

    private final TestDtoConverter testDtoConverter;

    @PostAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public void saveTest(@RequestBody TestCreationDto dto) {
        Test test = testService.save(new Test(null, dto.getName(), subjectService.getById(dto.getSubjectId()),null));
        List<Task> savedTasks = taskService.save(dto.getTasks(), test);
        for (int i = 0; i < savedTasks.size(); i++) {
            Task task = savedTasks.get(i);
            answerService.save(dto.getTasks().get(i).getAnswers(), task);
        }
    }

    @GetMapping
    public List<TestDto> getAll(){
        return testDtoConverter.toDto(testService.getAll());
    }


    @GetMapping("/{id}")
    public TestDtoWithTasks getById(@PathVariable("id") Long id){
        return testDtoConverter.toDto(testService.getById(id));
    }


}
