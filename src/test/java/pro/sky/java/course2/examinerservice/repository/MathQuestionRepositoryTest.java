package pro.sky.java.course2.examinerservice.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.examinerservice.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class MathQuestionRepositoryTest {

    private QuestionRepository questionRepository = new MathQuestionRepository();

    private Question[] initQuestions = {
            new Question("testQuestion1", "testAnswer1"),
            new Question("testQuestion2", "testAnswer2"),
            new Question("testQuestion3", "testAnswer3"),
    };

    private Question newQuestion = new Question("newQuestion", "newAnswer");

    @BeforeEach
    public void setUp() {
        for (Question q : initQuestions) {
            questionRepository.addQuestion(q);
        }
    }
    @Test
    public void getAllTest() {
        HashSet<Question> expected = new HashSet<>(Set.of(initQuestions));
        Collection<Question> result = questionRepository.getAll();
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void addTest() {
        Question expected = newQuestion;
        Question result = questionRepository.addQuestion(newQuestion);
        Assertions.assertEquals(expected, result);

        HashSet<Question> expectedAll = new HashSet<>(Set.of(initQuestions));
        expectedAll.add(newQuestion);
        Collection<Question> resultAll = questionRepository.getAll();
        Assertions.assertEquals(expectedAll, resultAll);
    }

    @Test
    public void removeTest() {
        questionRepository.addQuestion(newQuestion);

        Question expected = newQuestion;
        Question result = questionRepository.remove(newQuestion);
        Assertions.assertEquals(expected, result);

        HashSet<Question> expectedAll = new HashSet<>(Set.of(initQuestions));
        Collection<Question> resultAll = questionRepository.getAll();
        Assertions.assertEquals(expectedAll, resultAll);
    }

    @Test
    public void sizeTest() {
        int expected = initQuestions.length;
        int result = questionRepository.size();

        Assertions.assertEquals(expected, result);
    }
}
