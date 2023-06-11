package pro.sky.java.course2.examinerservice.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.examinerservice.Question;
import pro.sky.java.course2.examinerservice.repository.QuestionRepository;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {

    private Question newQuestion = new Question("mockQuestion", "mockAnswer");
    private Question otherQuestion = new Question("otherQuestion", "otherAnswer");

    private Set<Question> testQuestions = new HashSet<>(Set.of(
            new Question("question1", "answer1"),
            new Question("question2", "answer2"),
            new Question("question3", "answer3"),
            new Question("question4", "answer4")
    ));

    @Mock
    private QuestionRepository repositoryMock;
    @InjectMocks
    private JavaQuestionService out;

    @Test
    public void addAndRemoveTest() {
        when(repositoryMock.addQuestion(newQuestion))
                .thenReturn(newQuestion);
        when(repositoryMock.addQuestion(otherQuestion))
                .thenReturn(otherQuestion);
        when(repositoryMock.remove(newQuestion))
                .thenReturn(newQuestion);

        assertEquals(newQuestion, out.add(newQuestion));
        assertEquals(otherQuestion, out.add(otherQuestion.getQuestion(), otherQuestion.getAnswer()));
        assertEquals(newQuestion, out.remove(newQuestion));

        verify(repositoryMock, times(1)).addQuestion(newQuestion);
        verify(repositoryMock, times(1)).addQuestion(otherQuestion);
        verify(repositoryMock, times(1)).remove(newQuestion);
    }

    @Test
    public void getAllTest() {
        when(repositoryMock.getAll()).thenReturn(testQuestions);
        assertEquals(testQuestions, out.getAll());
    }

    @Test
    public void getRandomTest() {
        when(repositoryMock.getAll()).thenReturn(testQuestions);
        when(repositoryMock.size()).thenReturn(testQuestions.size());

        Question result = out.getRandomQuestion();
        assertTrue(testQuestions.contains(result));
    }

}
