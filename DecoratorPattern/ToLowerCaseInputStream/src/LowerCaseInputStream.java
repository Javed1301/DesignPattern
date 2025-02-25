import java.io.*;

public class LowerCaseInputStream extends FilterInputStream {

    protected LowerCaseInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        return (c == -1 ? c : Character.toLowerCase((char) c));
    }

    @Override
    public int read(byte[] b, int offset, int length) throws IOException {
        int result = super.read(b, offset, length);
        if (result != -1) {
            for (int i = offset; i < offset + result; i++) {
                b[i] = (byte) Character.toLowerCase((char) b[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        try {
            String text = "HELLO Decorator Pattern!";
            InputStream inputStream = new ByteArrayInputStream(text.getBytes());
            InputStream lowerCaseStream = new LowerCaseInputStream(inputStream);

            int c;
            while ((c = lowerCaseStream.read()) != -1) {
                System.out.print((char) c);
            }

            lowerCaseStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
