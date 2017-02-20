package concurrencydemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by meltzer on 17.02.17.
 */
public class concurrencydemo {
    public static void main(String[] args) {
        int tries = 0;
        int fails = 0;
        for (int i = 0; i < 1000; i++) {
            tries++;
            int j = DoTheJob();
            if (j != 10) {
                fails++;
            }
        }
        System.out.println(tries);
        System.out.println(fails);
        double f = (double) fails / tries * 100;
        System.out.println((int) f + "% of errors");
    }

    public static int DoTheJob() {
        Counter counter = new Counter();

        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        threadPool.execute(counter::increment);
        threadPool.execute(counter::increment);
        threadPool.execute(counter::increment);
        threadPool.execute(counter::increment);
        threadPool.execute(counter::increment);
        threadPool.execute(counter::increment);
        threadPool.execute(counter::increment);
        threadPool.execute(counter::increment);
        threadPool.execute(counter::increment);
        threadPool.execute(counter::increment);
        threadPool.shutdown();
        try {
            threadPool.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return counter.getCounter();
    }
}

class Counter {
    private volatile int counter;

    public synchronized void increment() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }
}