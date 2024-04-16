import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите название текстового файла:");
        String fileName = scanner.nextLine();

        System.out.println("Введите текст:");
        String textInput = scanner.nextLine();

        try (PrintWriter out = new PrintWriter(fileName)) {
            out.println(textInput);
            System.out.println("Текст успешно сохранен");
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            System.out.println("Содержимое файла" + fileName + ":");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
