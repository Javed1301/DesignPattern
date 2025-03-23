package streams;

import java.io.IOException;

public class LoggingDecorator extends DataStreamDecorator {
    public LoggingDecorator(InputStreamComponent stream) {
        super(stream);
    }

    @Override
    public int read() throws IOException {
        int data = super.read();
        if (data != -1) {
            log(data);
        }
        return data;
    }

    private void log(int data) {
        System.out.println("[LOG]: Read character - " + (char) data);
    }
}
