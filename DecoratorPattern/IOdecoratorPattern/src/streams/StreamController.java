package streams;

import java.io.IOException;
import java.util.Scanner;

public class StreamController {

    // Process file input
    public void processFile(String fileName) {
        try {
            InputStreamComponent fileStream = new FileInputStreamComponent(fileName);
            InputStreamComponent decoratedStream = applyDecorators(fileStream);

            System.out.println("\nProcessing file: " + fileName);
            readStream(decoratedStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Process string input
    public void processString(String data) {
        InputStreamComponent stringStream = new StringInputStream(data);
        InputStreamComponent decoratedStream = applyDecorators(stringStream);

        System.out.println("\nProcessing string input...");
        readStream(decoratedStream);
    }

    // Process console input
    public void processConsoleInput() {
        InputStreamComponent consoleStream = new ConsoleInputStream();
        InputStreamComponent decoratedStream = applyDecorators(consoleStream);

        System.out.println("\nProcessing console input. Type something and press Enter:");
        readStream(decoratedStream);
    }
    private final Scanner scanner = new Scanner(System.in);
    // Apply decorators dynamically
    private InputStreamComponent applyDecorators(InputStreamComponent stream) {
        InputStreamComponent decoratedStream = stream;
    
        while (true) {
            System.out.println("\n====== Choose Decorators ======");
            System.out.println("1. Encrypt Stream");
            System.out.println("2. Uppercase Stream");
            System.out.println("3. Encrypt + Uppercase");
            System.out.println("4. Uppercase + Encrypt");
            System.out.println("5. Compress Stream");
            System.out.println("6. Logging Stream");
            System.out.println("7. No Decorator (Exit)");
    
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
    
            switch (choice) {
                case 1:
                    decoratedStream = new EncryptionDecorator(decoratedStream);
                    break;
                case 2:
                    decoratedStream = new UppercaseDecorator(decoratedStream);
                    // decoratedStream = new PrintingDecorator(decoratedStream);
                    break;
                case 3:
                    decoratedStream = new UppercaseDecorator(new EncryptionDecorator(decoratedStream));
                    break;
                case 4:
                    decoratedStream = new EncryptionDecorator(new UppercaseDecorator(decoratedStream));
                    break;
                case 5:
                    decoratedStream = new CompressionDecorator(decoratedStream);
                    break;
                case 6:
                    decoratedStream = new LoggingDecorator(decoratedStream);
                    break;
                case 7:
                    System.out.println("No decorators applied. Exiting...");
                    return stream; // Return original if exit
                default:
                    System.out.println("Invalid choice. No decorators applied.");
            }
    
            // Ask to continue or exit after applying each decorator
            System.out.print("Apply more decorators? (y/n): ");
            String moreDecorators = scanner.next();
    
            if (moreDecorators.equalsIgnoreCase("n")) {
                break; // Exit loop if user says no
            }
        }
    
        return decoratedStream; // Return decorated stream
    }
    
    
    // Read and print data from any decorated stream
    private void readStream(InputStreamComponent stream) {
        try {
            int data;
            while ((data = stream.read()) != -1) {
                System.out.print((char) data); // Keep printing here
            }
            stream.close();
            System.out.println("\nStream closed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
