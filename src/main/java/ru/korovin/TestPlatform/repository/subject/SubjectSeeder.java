package ru.korovin.TestPlatform.repository.subject;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.korovin.TestPlatform.controller.TestController;
import ru.korovin.TestPlatform.domain.model.test.Answer;
import ru.korovin.TestPlatform.domain.model.test.Subject;
import ru.korovin.TestPlatform.domain.model.test.Task;
import ru.korovin.TestPlatform.domain.model.test.Test;
import ru.korovin.TestPlatform.repository.AnswerRepository;
import ru.korovin.TestPlatform.repository.TaskRepository;
import ru.korovin.TestPlatform.repository.TestRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SubjectSeeder implements CommandLineRunner {
    private final SubjectRepository subjectRepository;
    private final TestRepository testRepository;
    private final TaskRepository taskRepository;
    private final AnswerRepository answerRepository;


    @Override
    @Transactional
    public void run(String... args) throws Exception {
        subjectRepository.deleteAll();
        Subject subject = new Subject(null, "Java",null);
        subject = subjectRepository.save(subject);

        Test test = new Test(null, "Java Simple Test",subject,null);
        test = testRepository.save(test);

        Task task1 = new Task(null, "Java - what is?",test, null);
        task1 = taskRepository.save(task1);

        Answer answer1 = new Answer(null, "what?",true,task1);
        Answer answer2 = new Answer(null, "what the fuck?",true,task1);
        answerRepository.saveAll(List.of(answer1, answer2));

        Task task2 = new Task(null, "Java - for what?",test, null);
        task2 = taskRepository.save(task2);

        Answer answer3 = new Answer(null, "For what?",true,task2);
        Answer answer4 = new Answer(null, "For what the fuck?",true,task2);
        answerRepository.saveAll(List.of(answer3, answer4));

        System.out.printf("saved subject 'JAVA' id = %d%n",subject.getId());

    }
}
