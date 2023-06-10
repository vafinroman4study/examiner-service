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

    public boolean equals(Question q) {
        return question.equals(q.getQuestion()) && answer.equals(q.getAnswer());
    }

    public String toString() {
        return question + " " + answer;
    }

    public int hashCode() {
        return java.util.Objects.hash(question + answer);
    }
}
