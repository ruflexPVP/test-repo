import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exam {
    private int id;
    private Candidate candidate;
    private List<Question> questions = new ArrayList<>();
    private int score = 0;

    public Exam(int id, Candidate candidate) {
        this.id = id;
        this.candidate = candidate;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void conductExam() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать на экзамен, " + candidate.getName() + "!");
        System.out.println("У вас " + questions.size() + " вопросов.\n");

        for (Question question : questions) {
            System.out.println("Вопрос " + question.getId() + ": " + question.getText());
            String[] options = question.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }

            System.out.print("Ваш ответ (введите номер): ");
            int answer = scanner.nextInt() - 1;

            if (question.checkAnswer(answer)) {
                System.out.println("Верно!\n");
                score++;
            } else {
                System.out.println("Неверно. Правильный ответ: " + options[question.getCorrectOption()] + "\n");
            }
        }

        System.out.println("Экзамен завершен.");
        System.out.println("Ваш результат: " + score + "/" + questions.size());
    }

    public int getScore() {
        return score;
    }
    public List<Question> getQuestions() {
        return questions;
    }
}
