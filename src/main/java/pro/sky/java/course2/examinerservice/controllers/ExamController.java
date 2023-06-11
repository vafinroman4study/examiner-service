package pro.sky.java.course2.examinerservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.examinerservice.Question;
import pro.sky.java.course2.examinerservice.services.ExaminerService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/get/{amount}")
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/")
    public Collection<Question> printEmployeeOverDepartment(@PathVariable("amount") int amount) {
        return examinerService.getQuestions(amount);
    }
}
