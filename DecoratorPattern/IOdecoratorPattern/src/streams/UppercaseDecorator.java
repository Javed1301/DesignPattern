package streams;

import java.io.IOException;

public class UppercaseDecorator extends DataStreamDecorator {
    public UppercaseDecorator(InputStreamComponent stream) {
        super(stream);
    }

    @Override
    public int read() throws IOException {
        int data = super.read(); // Read a single character
        if (data == -1) {
            return data; // End of stream
        }

        // Convert to uppercase and return the int value
        return (int) Character.toUpperCase((char) data);
    }
}