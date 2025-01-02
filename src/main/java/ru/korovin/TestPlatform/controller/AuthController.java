package ru.korovin.TestPlatform.controller;


import jakarta.validation.Valid;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import ru.korovin.TestPlatform.config.security.UserAuthentication;
import ru.korovin.TestPlatform.domain.dto.sample.UserDto;
import ru.korovin.TestPlatform.domain.dto.creation.RegisterUserDto;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.korovin.TestPlatform.domain.exception.ValidationException;
import ru.korovin.TestPlatform.domain.model.user.User;
import ru.korovin.TestPlatform.domain.model.user.UserDetailsImpl;
import ru.korovin.TestPlatform.domain.util.validation.UserRegValidator;
import ru.korovin.TestPlatform.service.UserService;

import static org.springframework.security.web.context.HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY;

@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@RestController
public class AuthController {
    private final UserService userService;
    private final UserDetailsService userDetailsService;
    private final UserRegValidator userRegValidator;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public void register(@RequestBody @Valid RegisterUserDto dto, BindingResult errors, HttpServletRequest request){
        userRegValidator.validate(dto, errors);
        if(errors.hasErrors()){
            throw new ValidationException(errors.getFieldErrors());
        }
        userService.save(new User(dto));
        createSession(dto.getLogin(),request, null );
    }

    @PostMapping("/login")
    public void login(@RequestBody UserDto dto, HttpServletRequest request){
        Authentication authentication = authenticationManager.authenticate(new UserAuthentication(dto));
        createSession(authentication.getName(), request, authentication);
    }

    @PostMapping("/logout")
    public void logout(HttpSession httpSession, HttpServletRequest httpRequest, HttpServletResponse response){
        try{
            httpSession.invalidate();
            Cookie[] cookies = httpRequest.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    cookie.setValue(null);
                    cookie.setPath("/");
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
        }catch (Exception e){
            System.err.println("Ошибка при logout");
        }
    }

    private void createSession(String username,
                               HttpServletRequest request,
                               Authentication authentication) {
        SecurityContextHolder.getContext()
                .setAuthentication(
                        authentication == null  ? new UserAuthentication((UserDetailsImpl) userDetailsService.loadUserByUsername(username)) : authentication
                );
        HttpSession session = request.getSession(true);
        session.setAttribute(SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());
    }




}
