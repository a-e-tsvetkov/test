package dummy.jmh;

import org.openjdk.jmh.annotations.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

@Fork(value = 3, warmups = 1)
@BenchmarkMode(Mode.AverageTime)
@State(Scope.Benchmark)
public class MainTest {
    private int[][] arr;

    @Setup(Level.Trial)
    public void setUp() {
        arr = IntStream.range(0, 1000)
                .mapToObj(x -> new Random().ints(100000).toArray())
                .toArray(int[][]::new);
    }

    @Benchmark
    public int loop() {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
            }
        }
        return sum;
    }

    @Benchmark
    public int stream() {
        return Arrays.stream(arr)
                .flatMapToInt(a -> Arrays.stream(a))
                .sum();
    }

    public static void main(String[] args) throws IOException {
        org.openjdk.jmh.Main.main(args);
    }
}
