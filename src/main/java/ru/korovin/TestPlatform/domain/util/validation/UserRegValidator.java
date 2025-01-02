package ru.korovin.TestPlatform.domain.util.validation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.korovin.TestPlatform.domain.dto.creation.RegisterUserDto;
import ru.korovin.TestPlatform.service.UserService;


@Component
@RequiredArgsConstructor
public class UserRegValidator implements Validator {
    private final UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return RegisterUserDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RegisterUserDto user = (RegisterUserDto) target;
        if(userService.exists(user.getLogin())){
            errors.rejectValue("login","","Пользоваль с таким login уже существует");
        }
        if(!user.getPassword().equals(user.getPasswordConfirm())){
            errors.rejectValue("passwordConfirm","","Пароли не совпадают");
        }
    }
}
