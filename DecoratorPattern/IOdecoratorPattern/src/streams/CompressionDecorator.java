package streams;

import java.io.IOException;

public class CompressionDecorator extends DataStreamDecorator {
    public CompressionDecorator(InputStreamComponent stream) {
        super(stream);
    }

    @Override
    public int read() throws IOException {
        int data = super.read();
        return (data != -1) ? compress(data) : data;
    }

    private int compress(int data) {
        // Simulated compression logic (shrinking character ASCII by 1)
        return data - 1;
    }
}
