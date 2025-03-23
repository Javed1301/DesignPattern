package streams;

import java.io.IOException;

public class PrintingDecorator extends BufferedStreamDecorator {
    public PrintingDecorator(InputStreamComponent component) {
        super(component);
    }

    @Override
    public int read() throws IOException {
        int data = super.read();
        if (data != -1) {
            System.out.print((char) data);
        }
        return data;
    }
}