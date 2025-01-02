package ru.korovin.TestPlatform.domain.model.test;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Table(name = "answers")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String answer;
    @Column
    private boolean isCorrect;
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;
}
