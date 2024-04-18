import java.io.*;
import java.util.Scanner;

public class CreateTextFile {
    public static void createTextFile(Scanner scanner, String language) {
        System.out.println(language.equalsIgnoreCase("Russian") ? "Введите название файла:" : "Enter file name:");
        String fileName = "src/doc/" + scanner.nextLine();

        System.out.println(language.equalsIgnoreCase("Russian") ? "Введите текст:" : "Enter text:");
        String textInput = scanner.nextLine();

        try (PrintWriter out = new PrintWriter(fileName)) {
            out.println(textInput);
            System.out.println(language.equalsIgnoreCase("Russian") ? "Текст сохранен" : "Text saved");
        } catch (FileNotFoundException e) {
            System.err.println(language.equalsIgnoreCase("Russian") ? "Файл не найден: " + e.getMessage() : "File not found: " + e.getMessage());
        }
    }
}
