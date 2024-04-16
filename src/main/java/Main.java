import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String language = SelectLanguage.selectLanguage(scanner);
        int choice = ShowMenu.showMenu(scanner, language);

        switch (choice) {
            case 1:
                CreateTextFile.createTextFile(scanner, language);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}
