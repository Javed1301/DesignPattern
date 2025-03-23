import streams.StreamController;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        StreamController controller = new StreamController();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("\nReading from File:");
            controller.processFile("test.txt");

            System.out.println("\n\nReading from String:");
            controller.processString("Hello, Decorator Pattern from String!");

            System.out.println("\n\nReading from Console:");
            controller.processConsoleInput();
        } finally {
            // Close scanner only at the end
            scanner.close();
            System.out.println("Scanner closed successfully.");
        }
    }
}
