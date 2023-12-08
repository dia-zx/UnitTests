import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class TestTools {
    public static String ioListen(Runnable runnable, String ForInputStream) {
        InputStream in_last = System.in;
        ByteArrayInputStream io = new ByteArrayInputStream(ForInputStream.getBytes());
        System.setIn(io);

        PrintStream out_last = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream ps_out = new PrintStream(out);
        System.setOut(ps_out);

        runnable.run();

        System.setOut(out_last);
        System.setIn(in_last);
        return out.toString();
    }
}
