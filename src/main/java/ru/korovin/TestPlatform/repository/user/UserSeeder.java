package ru.korovin.TestPlatform.repository.user;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.korovin.TestPlatform.domain.model.user.Role;
import ru.korovin.TestPlatform.domain.model.user.User;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class UserSeeder implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        User defaultUser = new User(null,"user",passwordEncoder.encode("user"), Set.of(Role.USER));
        User admin = new User(null, "admin",passwordEncoder.encode("admin"),Set.of(Role.USER, Role.ADMIN));
        userRepository.save(defaultUser);
        userRepository.save(admin);
    }
}
