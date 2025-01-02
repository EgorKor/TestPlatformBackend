package ru.korovin.TestPlatform.domain.model.user;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.korovin.TestPlatform.domain.dto.creation.RegisterUserDto;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String login;
    @Column
    private String password;
    @Column
    private Set<Role> roles;

    public User(){}

    public User(RegisterUserDto dto){
        roles = Set.of(Role.USER);
        this.login = dto.getLogin();
        this.password = dto.getPassword();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles.toString() +
                '}';
    }
}
