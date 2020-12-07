package BinaryTree;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@State(Scope.Benchmark)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 2, jvmArgs = {"-Xms2G", "-Xmx2G"})
@Warmup(iterations = 1)
@Measurement(iterations = 5)
public class BenchmarkTree {

    final static int N = 1000;
    final static int[] searchElements = {723,656,999,1,534,221,33,26,999,12};
    static Tree SORT_TEST_DATA;
    static Tree RANDOM_TEST_DATA;

    @Setup
    public void setup(){
        SORT_TEST_DATA = new Tree(0);
        for (int i = 0; i < N; i++ ){
            SORT_TEST_DATA.insert(i);
        }
        RANDOM_TEST_DATA = new Tree(0);
        Random random = new Random();
        for (int i = 0; i < N-10; i++ ){
            RANDOM_TEST_DATA.insert(random.nextInt(1000));
        }
        for (int i : searchElements){
            RANDOM_TEST_DATA.insert(i);
        }
    }

    public static void main(String[]args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(BenchmarkTree.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @Benchmark
    public void testSortSearch(Blackhole bh){
        for (int i:searchElements) {
            bh.consume(SORT_TEST_DATA.search(i));
        }
    }

    @Benchmark
    public void testSortDelete(Blackhole bh){
        for (int i:searchElements) {
            SORT_TEST_DATA.deleting(i);
        }
    }

    @Benchmark
    public void testRandomSearch(Blackhole bh){
        for (int i:searchElements) {
            bh.consume(RANDOM_TEST_DATA.search(i));
        }
    }

    @Benchmark
    public void testRandomDelete(Blackhole bh){
        for (int i:searchElements) {
            RANDOM_TEST_DATA.deleting(i);
        }
    }
}