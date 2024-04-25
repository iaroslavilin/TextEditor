import java.io.*;
import java.util.*;

public class EditTextFile {
    public static void editTextFile(Scanner scanner, String language) {
        System.out.println(language.equalsIgnoreCase("Russian") ? "Введите название файла:" : "Enter file name:");
        String fileName = "src/main/java/" + scanner.nextLine();

        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println(language.equalsIgnoreCase("Russian") ? "Файл не найден: " + e.getMessage() : "File not found: " + e.getMessage());
            return;
        } catch (IOException e) {
            System.err.println(language.equalsIgnoreCase("Russian") ? "Ошибка при чтении файла: " + e.getMessage() : "Error reading the file: " + e.getMessage());
            return;
        }

        while (true) {
            System.out.println(language.equalsIgnoreCase("Russian") ? "Содержимое файла:" : "File contents:");
            int lineNumber = 1;
            for (String line : lines) {
                System.out.println(lineNumber + ": " + line);
                lineNumber++;
            }

            System.out.println(language.equalsIgnoreCase("Russian") ? "Введите номер строки для редактирования (0 для добавления в конец, saveEdit для сохранения):" : "Enter line number to edit (0 to add at the end, saveEdit to save):");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("saveEdit")) {
                break;
            }

            int lineToEdit;
            try {
                lineToEdit = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println(language.equalsIgnoreCase("Russian") ? "Введите корректный номер строки" : "Please enter a valid line number");
                continue;
            }

            if (lineToEdit == 0) {
                System.out.println(language.equalsIgnoreCase("Russian") ? "Введите текст для добавления:" : "Enter text to add:");
                lines.add(scanner.nextLine());
            } else if (lineToEdit > 0 && lineToEdit <= lines.size()) {
                System.out.println(language.equalsIgnoreCase("Russian") ? "Введите новый текст:" : "Enter new text:");
                lines.set(lineToEdit - 1, scanner.nextLine());
            } else {
                System.out.println(language.equalsIgnoreCase("Russian") ? "Неверный номер строки" : "Invalid line number");
            }
        }

        try (PrintWriter out = new PrintWriter(new FileWriter(fileName))) {
            for (String line : lines) {
                out.println(line);
            }
            System.out.println(language.equalsIgnoreCase("Russian") ? "Изменения сохранены" : "Changes saved");
        } catch (IOException e) {
            System.err.println(language.equalsIgnoreCase("Russian") ? "Ошибка при сохранении файла: " + e.getMessage() : "Error saving the file: " + e.getMessage());
        }
    }
}
