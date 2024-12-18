public class Question {
    private int id;
    private String text;
    private String[] options;
    private int correctOption;

    // Constructor
    public Question(int id, String text, String[] options, int correctOption) {
        this.id = id;
        this.text = text;
        this.options = options;
        this.correctOption = correctOption;
    }

    // Getter and Setter Methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public int getCorrectOption() {
        return correctOption;
    }

    public void setCorrectOption(int correctOption) {
        this.correctOption = correctOption;
    }

    // Method to check the answer
    public boolean checkAnswer(int selectedOption) {
        return selectedOption == correctOption;
    }
}
