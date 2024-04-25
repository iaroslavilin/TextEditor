import java.io.*;
import java.util.Scanner;

public class DeleteTextFile {
    public static void deleteTextFile(Scanner scanner, String language) {
        System.out.println(language.equalsIgnoreCase("Russian") ? "Введите название файла:" : "Enter file name:");
        String fileName = "src/main/java/" + scanner.nextLine();

        File file = new File(fileName);
        if (file.delete()) {
            System.out.println(language.equalsIgnoreCase("Russian") ? "Файл удален" : "File deleted");
        } else {
            System.out.println(language.equalsIgnoreCase("Russian") ? "Не удалось удалить файл" : "Failed to delete the file");
        }
    }
}
