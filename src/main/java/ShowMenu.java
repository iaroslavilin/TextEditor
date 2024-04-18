import java.util.Scanner;

public class ShowMenu {
    public static int showMenu(Scanner scanner, String language) {
        if (language.equalsIgnoreCase("Russian")) {
            System.out.println("Меню:");
            System.out.println("1. Создать текстовый файл");
            System.out.println("2. Удалить текстовый файл");
            System.out.println("3. Показать содержимое текстового файла");
            System.out.println("Введите номер команды:");
        } else {
            System.out.println("Menu:");
            System.out.println("1. Create a text file");
            System.out.println("2. Delete a text file");
            System.out.println("3. Show text file content");
            System.out.println("Enter command number:");
        }

        return Integer.parseInt(scanner.nextLine());
    }
}
