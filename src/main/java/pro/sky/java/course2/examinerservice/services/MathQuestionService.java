package pro.sky.java.course2.examinerservice.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.Question;
import pro.sky.java.course2.examinerservice.repository.QuestionRepository;

import java.util.Collection;
import java.util.Random;

@Service
public class MathQuestionService implements QuestionService {
    private QuestionRepository questions;

    public MathQuestionService(@Qualifier("mathQuestionRepository") QuestionRepository questions) {
        this.questions = questions;
    }

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questions.addQuestion(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        questions.addQuestion(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions.getAll();
    }

    @Override
    public int size() {
        return questions.size();
    }

    @Override
    public Question getRandomQuestion() {
        Random rnd = new Random();
        int rnd_num = rnd.nextInt(questions.size());
        int i = 0;
        for (Question question : questions.getAll()) {
            if (i == rnd_num) {
                return question;
            }
            i++;
        }
        return null;
    }
}
