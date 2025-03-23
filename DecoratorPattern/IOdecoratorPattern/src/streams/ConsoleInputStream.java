package streams;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInputStream extends InputStreamComponent {
    private BufferedReader consoleReader;

    public ConsoleInputStream() {
        consoleReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public int read() throws IOException {
        String input = consoleReader.readLine(); // Read full line
        
        // Handle empty or null input safely
        if (input == null || input.isEmpty()) {
            return -1; // Return -1 to signal end of stream
        }

        // Convert input string to bytes for processing
        byte[] inputBytes = input.getBytes();
        ByteArrayInputStream byteStream = new ByteArrayInputStream(inputBytes);
        
        return byteStream.read(); // Return first character or -1 if empty
    }

    @Override
    public void close() throws IOException {
        consoleReader.close();
    }
}
