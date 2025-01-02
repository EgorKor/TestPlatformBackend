package ru.korovin.TestPlatform.service;

import ru.korovin.TestPlatform.domain.model.user.User;

public interface UserService {
    User getUserByLogin(String login);
    boolean exists(String login);

    User save(User user);



}
