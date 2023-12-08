import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class TestTools {
    /**
     * Подменяет потоки ввода и вывода для возможности тестирования и анализа
     * @param runnable Запускаемый метод для тестирования потоков
     * @param ForInputStream данная строка передается в поток ввода, имитируя пользовательский ввод
     * @return строка записанная потоком вывода (для тестирования выводимых сообщений)
     */
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
