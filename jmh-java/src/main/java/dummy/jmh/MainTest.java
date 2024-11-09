package dummy.jmh;

import org.openjdk.jmh.annotations.Benchmark;

import java.io.IOException;

public class MainTest {

    @Benchmark
    public void wellHelloThere() {
        // this method was intentionally left blank.
    }

    public static void main(String[] args) throws IOException {
        org.openjdk.jmh.Main.main(args);
    }
}
