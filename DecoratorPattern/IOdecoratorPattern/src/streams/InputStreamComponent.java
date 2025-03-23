package streams;


import java.io.IOException;

public abstract class InputStreamComponent {
    public abstract int read() throws IOException;
    public abstract void close() throws IOException;
}
