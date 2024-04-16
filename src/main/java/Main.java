import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String language = selectLanguage(scanner);
        int choise = showMenu(scanner, language);

        switch (choise) {
            case 1:
                createTextFile(scanner, language);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    private static String selectLanguage(Scanner scanner) {
        System.out.println("Select language:");
        System.out.println("1. Russian");
        System.out.println("2. English");

        int choice = Integer.parseInt(scanner.nextLine());
        if (choice == 1) {
            return "Russian";
        } else {
            return "English";
        }
    }

    private static int showMenu(Scanner scanner, String language) {
        if (language.equalsIgnoreCase("Russian")) {
            System.out.println("Меню:");
            System.out.println("1. Создать текстовый файл");
            System.out.println("Введите номер команды:");
        } else {
            System.out.println("Menu:");
            System.out.println("1. Create a text file");
            System.out.println("Enter command number:");
        }

        return Integer.parseInt(scanner.nextLine());
    }

    private static void createTextFile(Scanner scanner, String language) {
        System.out.println(language.equalsIgnoreCase("Russian") ? "Введите название файла:" : "Enter file name:");
        String fileName = scanner.nextLine();

        System.out.println(language.equalsIgnoreCase("Russian") ? "Введите текст:" : "Enter text:");
        String textInput = scanner.nextLine();

        try (PrintWriter out = new PrintWriter(fileName)) {
            out.println(textInput);
            System.out.println(language.equalsIgnoreCase("Russian") ? "Текст сохранен" : "Text is save");
        } catch (FileNotFoundException e) {
            System.err.println(language.equalsIgnoreCase("Russian") ? "Файл не найден: " + e.getMessage() : "File not found: " + e.getMessage());
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            System.out.println(language.equalsIgnoreCase("Russian") ? "Содержимое файла " + fileName + ":" : "File contents " + fileName + ":");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println(language.equalsIgnoreCase("Russian") ? "Ошибка чтения файла: " + e.getMessage() : "Error reading file: " + e.getMessage());
        }
    }
}
