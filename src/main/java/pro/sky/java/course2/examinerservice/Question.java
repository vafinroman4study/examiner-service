package pro.sky.java.course2.examinerservice;

public class Question {
    private String question;

    private String answer;

    public Question(String question, String answer) {
        this.answer = answer;
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public String getQuestion() {
        return question;
    }

    @Override
    public boolean equals(Object q) {
        if (q == null || getClass() != q.getClass()) return false;
        return hashCode() == q.hashCode(); // question.equals(q.getQuestion()) && answer.equals(q.getAnswer());
    }

    public String toString() {
        return question + "? " + answer;
    }

    public int hashCode() {
        return java.util.Objects.hash(question + answer);
    }
}
