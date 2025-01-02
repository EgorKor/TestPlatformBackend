package ru.korovin.TestPlatform.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.korovin.TestPlatform.domain.dto.creation.SubjectCreationDto;
import ru.korovin.TestPlatform.domain.dto.sample.SubjectDto;
import ru.korovin.TestPlatform.domain.util.converter.SubjectDtoConverter;
import ru.korovin.TestPlatform.service.SubjectService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/subjects")
@RequiredArgsConstructor
public class SubjectController {
    private final SubjectService subjectService;
    private final SubjectDtoConverter subjectDtoConverter;

    //region BasicCRUD
    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void save(SubjectCreationDto dto){
        subjectService.save(subjectDtoConverter.toModel(dto));
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(SubjectDto dto){
        subjectService.save(subjectDtoConverter.toModel(dto));
    }

    @GetMapping
    public List<SubjectDto> getAllSubjects(){
        return subjectDtoConverter.toDto(subjectService.getAll());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id){
        subjectService.delete(id);
    }
    //endregion

}
