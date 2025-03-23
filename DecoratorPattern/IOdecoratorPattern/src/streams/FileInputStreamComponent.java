package streams;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamComponent extends InputStreamComponent {
    private FileInputStream fileInputStream;

    public FileInputStreamComponent(String fileName) throws IOException {
        fileInputStream = new FileInputStream(fileName);
    }

    @Override
    public int read() throws IOException {
        return fileInputStream.read();
    }

    @Override
    public void close() throws IOException {
        fileInputStream.close();
    }
}
