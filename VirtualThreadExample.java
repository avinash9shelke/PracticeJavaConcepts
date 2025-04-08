import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author avinash
 * <p>
 * JVM-managed lightweight threads that help in writing high-throughput concurrent applications.
 * 1.Virtual threads are stored in the JVM heap.
 * 2.Virtual threads are scheduled by the JVM via a work-stealing ForkJoinPool scheduler.
 * 3.Virtual threads are always daemon threads.
 * 4.Virtual threads always have the normal priority and the priority cannot be changed.
 * 5.Virtual threads are not active members of thread groups.
 * 6.Virtual threads do not support the stop(), suspend(), or resume() methods.
 */
public class VirtualThreadExample {
    static Runnable runnable = () -> System.out.println("Inside Runnable " + Thread.currentThread());   // Task to run

    public static void main(String[] args) throws InterruptedException {
        virtualThreadExecution();
        platformThreadExecution();
        virtualThread();
    }

    public static void virtualThread() throws InterruptedException {
        var start = System.currentTimeMillis();
        var totalThread = 10000;
        var threads = IntStream.range(0, totalThread)
                .mapToObj(
                        thCount -> Thread.ofVirtual().unstarted(() -> {
                        })).toList();
        threads.forEach(Thread::start);
        for (Thread thread : threads) {
            thread.join();
        }
        var end = System.currentTimeMillis();
        System.out.println("millis used to launch " + totalThread + " vthreads:" + (end - start) + "ms");
    }
    public static void virtualThreadExecution() {
        Instant start = Instant.now();

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 10_000; i++) {
                executor.submit(runnable);
            }
        }
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Virtual Total elapsed time : " + timeElapsed);
    }

    public static void platformThreadExecution() {
        Instant start = Instant.now();

        try (var executor = Executors.newFixedThreadPool(100)) {
            for (int i = 0; i < 10_000; i++) {
                executor.submit(runnable);
            }
        }

        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Platform Total elapsed time : " + timeElapsed);
    }
}
