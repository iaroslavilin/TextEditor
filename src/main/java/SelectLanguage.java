import java.util.Scanner;

public class SelectLanguage {
    public static String selectLanguage(Scanner scanner) throws LanguageException {
        System.out.println("Select language:");
        System.out.println("1. Russian");
        System.out.println("2. English");
        System.out.println("Enter command number:");

        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice == 1) {
                    return "Russian";
                } else if (choice == 2) {
                    return "English";
                } else {
                    throw new LanguageException("Invalid language choice");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
            } catch (LanguageException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
