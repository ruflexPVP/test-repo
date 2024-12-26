import java.util.Objects;

public class Question implements Entity {
    private int id;
    private String text;
    private String[] options;
    private int correctOption;

    public Question(int id, String text, String[] options, int correctOption) {
        this.id = id;
        this.text = text;
        this.options = options;
        this.correctOption = correctOption;
    }

    @Override
    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectOption() {
        return correctOption;
    }

    public boolean checkAnswer(int selectedOption) {
        return selectedOption == correctOption;
    }

    @Override
    public String toString() {
        return "Question ID: " + id + ", Text: " + text;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Question question = (Question) obj;
        return id == question.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

