package streams;

import java.io.IOException;

public class BufferedStreamDecorator extends InputStreamComponent {
    protected InputStreamComponent component;

    public BufferedStreamDecorator(InputStreamComponent component) {
        this.component = component;
    }

    @Override
    public int read() throws IOException {
        return component.read();
    }

    @Override
    public void close() throws IOException {
        component.close();
    }
}
