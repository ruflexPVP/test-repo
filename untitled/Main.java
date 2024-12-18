public class Main {
    public static void main(String[] args) {
        Candidate candidate = new Candidate(1, "John Doe", "john.doe@example.com");

        Question q1 = new Question(1, "What is 2+2?", new String[]{"3", "4", "5", "6"}, 1);
        Question q2 = new Question(2, "What is the capital of France?", new String[]{"Rome", "Berlin", "Paris", "Madrid"}, 2);

        Exam exam = new Exam(1, candidate);
        exam.addQuestion(q1);
        exam.addQuestion(q2);

        exam.conductExam();
        exam.calculateScore();
    }
}
