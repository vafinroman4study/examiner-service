package pro.sky.java.course2.examinerservice.repository;

import org.springframework.stereotype.Repository;
import pro.sky.java.course2.examinerservice.Question;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Repository
public class MathQuestionRepository implements QuestionRepository {
    private Set<Question> questions;

    @PostConstruct
    public void init() {
        Question[] initQuestions = {
                new Question("mathQuestion1?", "mathAnswer1."),
                new Question("mathQuestion2?", "mathAnswer2."),
                new Question("mathQuestion3?", "mathAnswer3."),
                new Question("mathQuestion4?", "mathAnswer4."),
                new Question("mathQuestion5?", "mathAnswer5."),
                new Question("mathQuestion6?", "mathAnswer6."),
                new Question("mathQuestion7?", "mathAnswer7.")
        };

        questions = new HashSet<>();
        Collections.addAll(questions, initQuestions);
    }

    @Override
    public Question addQuestion(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public int size() {
        return questions.size();
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }
}
