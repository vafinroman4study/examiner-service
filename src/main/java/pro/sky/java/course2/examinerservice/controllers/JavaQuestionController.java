package pro.sky.java.course2.examinerservice.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.examinerservice.Question;
import pro.sky.java.course2.examinerservice.services.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(@Qualifier("javaQuestionService") QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/")
    public Collection<Question> getQuestions() {
        return questionService.getAll();
    }
    @GetMapping("/remove")
    public Question removeEmployee(@RequestParam String question,
                                   @RequestParam String answer) {
        Question questionRem = new Question(question, answer);
        return questionService.remove(questionRem);
    }
    @GetMapping("/add")
    public Question addEmployee(@RequestParam String question,
                                @RequestParam String answer) {
        return questionService.add(question, answer);
    }
}
