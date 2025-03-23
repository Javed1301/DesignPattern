package streams;

import java.io.IOException;

public class DataStreamDecorator extends BufferedStreamDecorator {
    public DataStreamDecorator(InputStreamComponent component) {
        super(component);
    }

    @Override
    public int read() throws IOException {
        // Just pass through without printing
        return super.read();
    }
}