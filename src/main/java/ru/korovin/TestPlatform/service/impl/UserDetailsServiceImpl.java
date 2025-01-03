package ru.korovin.TestPlatform.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.korovin.TestPlatform.domain.model.user.UserDetailsImpl;
import ru.korovin.TestPlatform.repository.user.UserRepository;


@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new UserDetailsImpl(userRepository.findByLogin(username).orElseThrow(() -> new UsernameNotFoundException("Пользоваель с таким login не найден")));
    }
}
