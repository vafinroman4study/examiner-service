package pro.sky.java.course2.examinerservice.repository;

import pro.sky.java.course2.examinerservice.Question;

import java.util.Collection;


public interface QuestionRepository {

    Question addQuestion(Question question);

    Collection<Question> getAll();

    int size();

    Question remove(Question question);
}
