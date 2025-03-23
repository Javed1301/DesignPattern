package streams;

import java.io.IOException;

public class EncryptionDecorator extends DataStreamDecorator {
    public EncryptionDecorator(InputStreamComponent stream) {
        super(stream);
    }

    @Override
    public int read() {
        int data;
        try {
            data = super.read();
        } catch (IOException e) {
            e.printStackTrace();
            return -1; // or handle the error as needed
        }
        return (data != -1) ? encrypt(data) : data;
    }

    private int encrypt(int data) {
        // Simple XOR encryption (for demonstration)
        return data ^ 5;
    }
}

