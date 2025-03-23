package streams;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class StringInputStream extends InputStreamComponent {
    private ByteArrayInputStream byteStream;

    public StringInputStream(String data) {
        byteStream = new ByteArrayInputStream(data.getBytes());
    }

    @Override
    public int read() throws IOException {
        return byteStream.read();
    }

    @Override
    public void close() throws IOException {
        byteStream.close();
    }
}
