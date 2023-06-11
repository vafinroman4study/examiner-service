package pro.sky.java.course2.examinerservice.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.examinerservice.Question;
import pro.sky.java.course2.examinerservice.exceptions.NotEnoughQuestions;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    Question[] testQuestions = {
            new Question("question1", "answer1"),
            new Question("question2", "answer2"),
            new Question("question3", "answer3"),
            new Question("question4", "answer4")
    };
    private Set<Question> questionSet = new HashSet<>(Set.of(
            testQuestions
    ));

    @Mock
    private QuestionService mockServcie;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    public void getQuestionsTest() {
        when(mockServcie.getRandomQuestion()).thenReturn(
                testQuestions[1], testQuestions[3], testQuestions[3],
                testQuestions[2], testQuestions[2], testQuestions[0]
        );
        when(mockServcie.size()).thenReturn(testQuestions.length);

        Collection<Question> result = examinerService.getQuestions(3);

        System.out.println(questionSet.containsAll(result));
        System.out.println(result);
        System.out.println(result.size());
    }

    @Test
    public void getQuestionsErrorTest() {
        when(mockServcie.size()).thenReturn(testQuestions.length);
        // Один мок отвечает за вызов обоих сервисов: MathQuestionService и JavaQuestionService
        Assertions.assertThrows(NotEnoughQuestions.class, () -> examinerService.getQuestions(2*testQuestions.length+1));
        Assertions.assertThrows(NotEnoughQuestions.class, () -> examinerService.getQuestions(-1));
    }

    //Collection<Question> getQuestions(int amount);
}
