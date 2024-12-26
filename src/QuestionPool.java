import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class QuestionPool {
    private List<Question> questions = new ArrayList<>();

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public Question findById(int id) {
        return questions.stream()
                .filter(q -> q.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Question> filterByKeyword(String keyword) {
        return questions.stream()
                .filter(q -> q.getText().contains(keyword))
                .collect(Collectors.toList());
    }

    public void sortByText() {
        questions.sort(Comparator.comparing(Question::getText));
    }

    public List<Question> getAll() {
        return questions;
    }

}

