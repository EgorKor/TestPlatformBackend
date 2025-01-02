package ru.korovin.TestPlatform.domain.util.parser;


import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.korovin.TestPlatform.domain.model.test.Answer;
import ru.korovin.TestPlatform.domain.model.test.Task;
import ru.korovin.TestPlatform.domain.model.test.Test;
import ru.korovin.TestPlatform.repository.TestRepository;

import javax.swing.text.html.parser.Parser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TestParser implements CommandLineRunner {
    private final ResourceLoader resourceLoader;
    private final TestRepository testRepository;

    @SneakyThrows
    public Test parseTest(String filePath) {
        BufferedReader br = new BufferedReader(new FileReader(filePath));

        String name = br.readLine();
        assert name != null;
        Test test = new Test();
        List<Task> tasks = new ArrayList<>();
        test.setName(name);
        String input = br.readLine();
        while (input != null) {
            if (Character.isDigit(input.charAt(0))) {
                Task task = new Task();
                String taskName = input;
                task.setTask(taskName);
                input = br.readLine();
                List<Answer> answers = new ArrayList<>();
                while(input != null && !Character.isDigit(input.charAt(0))){
                    Answer answer = new Answer();
                    if(input.charAt(0) == '+'){
                        answer.setCorrect(true);
                    }
                    input = input.substring(2);
                    answer.setAnswer(input);
                    answer.setTask(task);
                    answers.add(answer);
                    input = br.readLine();
                }
                task.setAnswers(answers);
                task.setTest(test);
                tasks.add(task);
                continue;
            }
            input = br.readLine();
        }
        test.setTasks(tasks);
        return test;
    }


    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Resource resource = resourceLoader.getResource("classpath:tests");
        File folder = resource.getFile();
        for (File file : folder.listFiles()) {
            Test parsedTest = parseTest(file.getAbsolutePath());

            testRepository.save(parsedTest);
        }
    }
}
