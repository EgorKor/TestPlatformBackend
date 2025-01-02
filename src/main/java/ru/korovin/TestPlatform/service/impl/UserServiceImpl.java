package ru.korovin.TestPlatform.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.korovin.TestPlatform.domain.model.user.User;
import ru.korovin.TestPlatform.repository.user.UserRepository;
import ru.korovin.TestPlatform.service.UserService;

import java.lang.module.ResolutionException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User getUserByLogin(String login) {
        return userRepository.findByLogin(login).orElseThrow(ResolutionException::new);
    }

    @Override
    public boolean exists(String login) {
        return userRepository.existsByLogin(login);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
