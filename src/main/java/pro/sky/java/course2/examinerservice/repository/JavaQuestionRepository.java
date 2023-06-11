package pro.sky.java.course2.examinerservice.repository;

import org.springframework.stereotype.Repository;
import pro.sky.java.course2.examinerservice.Question;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Repository
public class JavaQuestionRepository implements QuestionRepository {
    private Set<Question> questions = new HashSet<>();

    @PostConstruct
    public void init() {
        Question[] initQuestions = {
                new Question("javaQuestion1?", "javaAnswer1."),
                new Question("javaQuestion2?", "javaAnswer2."),
                new Question("javaQuestion3?", "javaAnswer3."),
                new Question("javaQuestion4?", "javaAnswer4."),
                new Question("javaQuestion5?", "javaAnswer5."),
                new Question("javaQuestion6?", "javaAnswer6."),
                new Question("javaQuestion7?", "javaAnswer7.")
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
