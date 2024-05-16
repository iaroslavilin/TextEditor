import java.util.Scanner;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        Instant startTime = Instant.now();
        Scanner scanner = new Scanner(System.in);
        String language = null;

        try {
            language = SelectLanguage.selectLanguage(scanner);
        } catch (LanguageException e) {
            System.err.println("Error: " + e.getMessage());
            return;
        }

        int choice = ShowMenu.showMenu(scanner, language);

        switch (choice) {
            case 1:
                CreateTextFile.createTextFile(scanner, language);
                break;
            case 2:
                DeleteTextFile.deleteTextFile(scanner, language);
                break;
            case 3:
                ReadTextFile.readTextFile(scanner, language);
                break;
            case 4:
                EditTextFile.editTextFile(scanner, language);
                break;
            default:
                System.out.println(language.equalsIgnoreCase("Russian") ? "Неверный выбор" : "Invalid choice");
        }

        Instant endTime = Instant.now();
        Duration duration = Duration.between(startTime, endTime);
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss").withZone(ZoneId.systemDefault());

        System.out.println(language.equalsIgnoreCase("Russian") ? "Время начала работы: " + timeFormatter.format(startTime) : "Start time: " + timeFormatter.format(startTime));
        System.out.println(language.equalsIgnoreCase("Russian") ? "Время окончания работы: " + timeFormatter.format(endTime) : "End time: " + timeFormatter.format(endTime));

        long hours = duration.toHours();
        long minutes = duration.toMinutesPart();
        long seconds = duration.toSecondsPart();

        System.out.println(language.equalsIgnoreCase("Russian") ? "Продолжительность работы: " + hours + " часов " + minutes + " минут " + seconds + " секунд" : "Duration of work: " + hours + " hours " + minutes + " minutes " + seconds + " seconds");
    }
}
