import java.io.*;
import java.util.Scanner;

public class ReadTextFile {
    public static void readTextFile(Scanner scanner, String language) {
        System.out.println(language.equalsIgnoreCase("Russian") ? "Введите название файла:" : "Enter file name:");
        String fileName = "src/doc/" + scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            System.out.println(language.equalsIgnoreCase("Russian") ? "Содержимое файла:" : "File contents:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println(language.equalsIgnoreCase("Russian") ? "Ошибка чтения файла: " + e.getMessage() : "Error reading file: " + e.getMessage());
        }
    }
}
