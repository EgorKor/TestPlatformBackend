package ru.korovin.TestPlatform.config.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import ru.korovin.TestPlatform.domain.dto.sample.UserDto;
import ru.korovin.TestPlatform.domain.model.user.User;
import ru.korovin.TestPlatform.domain.model.user.UserDetailsImpl;

import java.util.Collection;

public class UserAuthentication implements Authentication {
    private UserDetailsImpl userDetails;
    private boolean isAuthenticated;
    private User user;
    private UserDto userDto;


    public UserAuthentication(UserDetailsImpl userDetails) {
        this.userDetails = userDetails;
        this.user = userDetails.getUser();
        isAuthenticated = true;
    }

    public UserAuthentication(UserDto dto){
        this.userDto = dto;
    }

    public UserDto getAuthDto(){
        return userDto;
    }

    public User getUser(){
        return user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userDetails.getAuthorities();
    }

    @Override
    public Object getCredentials() {
        return userDetails.getPassword();
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return userDetails.getUser();
    }

    @Override
    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.isAuthenticated = isAuthenticated;
    }

    @Override
    public String getName() {
        return userDetails.getUsername();
    }
}
