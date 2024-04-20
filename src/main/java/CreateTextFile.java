import java.io.*;
import java.util.Scanner;

public class CreateTextFile {
    public static void createTextFile(Scanner scanner, String language) {
        System.out.println(language.equalsIgnoreCase("Russian") ? "Введите название файла:" : "Enter file name:");
        String fileName = scanner.nextLine();

        if (!fileName.endsWith(".txt")) {
            System.out.println(language.equalsIgnoreCase("Russian") ? "Файл должен иметь расширение .txt" : "File must have .txt extension");
            return;
        }

        fileName = "src/doc/" + fileName;

        System.out.println(language.equalsIgnoreCase("Russian") ? "Введите текст (введите saveText для сохранения):" : "Enter text (type saveText to save):");
        StringBuilder content = new StringBuilder();
        String line;
        while (!(line = scanner.nextLine()).equalsIgnoreCase("saveText")) {
            content.append(line).append(System.lineSeparator());
        }

        try (PrintWriter out = new PrintWriter(fileName)) {
            out.print(content.toString());
            System.out.println(language.equalsIgnoreCase("Russian") ? "Текст сохранен" : "Text saved");
        } catch (FileNotFoundException e) {
            System.err.println(language.equalsIgnoreCase("Russian") ? "Файл не найден: " + e.getMessage() : "File not found: " + e.getMessage());
        }
    }
}
