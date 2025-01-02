package ru.korovin.TestPlatform.domain.dto.creation;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class RegisterUserDto {
    @Length(min = 3, max = 16, message = "Длина логина должна быть от 3 до 16 символов")
    private String login;
    @Length(min = 8, max = 16, message = "Длина пароля должна быть от 8 до 16 символов")
    private String password;
    private String passwordConfirm;
}
