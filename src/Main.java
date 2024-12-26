import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        QuestionPool pool = new QuestionPool();

        // Добавление начальных вопросов
        pool.addQuestion(new Question(1, "Что такое 2+2?", new String[]{"3", "4", "5"}, 1));
        pool.addQuestion(new Question(2, "Столица Франции?", new String[]{"Париж", "Берлин", "Мадрид"}, 0));
        pool.addQuestion(new Question(3, "Сколько дней в неделе?", new String[]{"5", "6", "7"}, 2));

        Scanner scanner = new Scanner(System.in);

        // Выбор роли
        System.out.println("Выберите роль:");
        System.out.println("1. Администратор");
        System.out.println("2. Кандидат");
        int role = scanner.nextInt();
        scanner.nextLine(); // Очищаем буфер

        if (role == 1) {
            adminMode(pool, scanner);
        } else if (role == 2) {
            candidateMode(pool, scanner);
        } else {
            System.out.println("Некорректный выбор.");
        }
    }

    private static void adminMode(QuestionPool pool, Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.println("\nМеню администратора:");
            System.out.println("1. Добавить вопрос");
            System.out.println("2. Редактировать вопрос");
            System.out.println("3. Показать все вопросы");
            System.out.println("4. Выход");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Очищаем буфер

            switch (choice) {
                case 1 -> {
                    System.out.println("Введите ID вопроса:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Введите текст вопроса:");
                    String text = scanner.nextLine();
                    System.out.println("Введите варианты ответа через запятую:");
                    String[] options = scanner.nextLine().split(",");
                    System.out.println("Введите номер правильного варианта (с 0):");
                    int correctOption = scanner.nextInt();
                    scanner.nextLine();

                    pool.addQuestion(new Question(id, text, options, correctOption));
                }
                case 2 -> {
                    System.out.println("Введите ID вопроса для редактирования:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Введите новый текст вопроса:");
                    String text = scanner.nextLine();
                    System.out.println("Введите новые варианты ответа через запятую:");
                    String[] options = scanner.nextLine().split(",");
                    System.out.println("Введите новый номер правильного варианта (с 0):");
                    int correctOption = scanner.nextInt();
                    scanner.nextLine();


                }
                case 3 -> {
                    System.out.println("\nВсе вопросы:");
                    pool.getAll().forEach(System.out::println);
                }
                case 4 -> {
                    running = false;
                    System.out.println("Выход из режима администратора.");
                }
                default -> System.out.println("Некорректный выбор.");
            }
        }
    }

    private static void candidateMode(QuestionPool pool, Scanner scanner) {
        System.out.println("\nВведите ID кандидата:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Введите имя кандидата:");
        String name = scanner.nextLine();
        System.out.println("Введите email кандидата:");
        String email = scanner.nextLine();

        Candidate candidate = new Candidate(id, name, email);
        System.out.println("\nКандидат: " + candidate);

        System.out.println("\nНачинаем экзамен...");
        int score = 0;

        for (Question question : pool.getAll()) {
            System.out.println(question.getText());
            String[] options = question.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }
            System.out.print("Ваш ответ: ");
            int answer = scanner.nextInt() - 1; // Пользователь вводит номер с 1
            if (question.checkAnswer(answer)) {
                System.out.println("Верно!\n");
                score++;
            } else {
                System.out.println("Неверно. Правильный ответ: " + options[question.getCorrectOption()] + "\n");
            }
        }

        System.out.println("Экзамен завершен.");
        System.out.println("Результат: " + score + "/" + pool.getAll().size());
    }
}
