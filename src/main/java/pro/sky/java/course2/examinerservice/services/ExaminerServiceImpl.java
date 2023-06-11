package pro.sky.java.course2.examinerservice.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import pro.sky.java.course2.examinerservice.Question;
import pro.sky.java.course2.examinerservice.exceptions.NotEnoughQuestions;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

@Service
@SessionScope
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;

    public ExaminerServiceImpl(QuestionService javaQuestionService,
                               QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }
    @Override
    public Collection<Question> getQuestions(int amount) {
        HashSet<Question> questions = new HashSet<>();
        Random random = new Random();
        if (amount < javaQuestionService.size()+mathQuestionService.size() && amount > 0) {
            while (questions.size() < amount) {
                boolean rand = random.nextBoolean();
                if (rand) {
                    questions.add(javaQuestionService.getRandomQuestion());
                } else {
                    questions.add(mathQuestionService.getRandomQuestion());
                }
            }
            return questions;
        }
        throw new NotEnoughQuestions("Задано неверное количество случайных вопросов.");
    }
}
