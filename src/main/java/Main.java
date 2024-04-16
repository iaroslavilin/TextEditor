import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a text file name:");
        String fileName = scanner.nextLine();

        System.out.println("Enter text:");
        String textInput = scanner.nextLine();

        try (PrintWriter out = new PrintWriter(fileName)) {
            out.println(textInput);
            System.out.println("Text is save");
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            System.out.println("File contents" + fileName + ":");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
