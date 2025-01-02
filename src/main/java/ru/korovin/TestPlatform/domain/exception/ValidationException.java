package ru.korovin.TestPlatform.domain.exception;

import lombok.Getter;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Getter
public class ValidationException extends RuntimeException {
    private final Map<String, String> errors;

    public ValidationException(List<FieldError> fieldErrors) {
        errors = new LinkedHashMap<>();
        for (FieldError error : fieldErrors) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
    }

}
