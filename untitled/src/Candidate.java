import java.util.Scanner;

public class Candidate {
    private int id;
    private String name;
    private String email;

    // Конструктор без параметров, чтобы позволить ввод данных
    public Candidate() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите ID кандидата:");
        this.id = scanner.nextInt();
        scanner.nextLine(); // Очищаем буфер после ввода числа

        System.out.println("Введите имя кандидата:");
        this.name = scanner.nextLine();

        System.out.println("Введите email кандидата:");
        this.email = scanner.nextLine();
    }

    // Геттеры и сеттеры
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
