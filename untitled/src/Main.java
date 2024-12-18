public class Main {
    public static void main(String[] args) {
        // Создаем кандидата с вводом данных
        Candidate candidate = new Candidate();

        // Создаем вопросы
        Question q1 = new Question(1, "Что такое 2 + 2?", new String[]{"3", "4", "5"}, 1);
        Question q2 = new Question(2, "Столица Франции?", new String[]{"Париж", "Берлин", "Мадрид"}, 0);
        Question q3 = new Question(3, "Сколько дней в неделе?", new String[]{"5", "6", "7"}, 2);

        // Создаем экзамен
        Exam exam = new Exam(101, candidate);
        exam.addQuestion(q1);
        exam.addQuestion(q2);
        exam.addQuestion(q3);

        // Проводим экзамен
        exam.conductExam();

        // Итог
        int totalQuestions = exam.getQuestions().size();
        int score = exam.getScore();
        double percentage = (double) score / totalQuestions * 100;

        System.out.println("\nИтоговый результат:");
        System.out.println("Кандидат: " + candidate.getName() + " (" + candidate.getEmail() + ")");
        System.out.println("Правильных ответов: " + score + " из " + totalQuestions);
        System.out.printf("Процент успешности: %.2f%%\n", percentage);
    }
}
