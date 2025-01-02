package ru.korovin.TestPlatform.domain.util.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import ru.korovin.TestPlatform.domain.model.user.User;

import java.util.Collection;

@Component
public class SecurityUtils {
    public User getUser(){
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public void printRoles(){
        SecurityContextHolder.getContext().getAuthentication().getAuthorities().forEach(System.out::println);
    }
}
