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
        for (int i = 0; i < 100; i++) {
            tries++;
            int j = DoTheJob();
            if (j != 12) {
                fails++;
            }
        }
        System.out.println(tries);
        System.out.println(fails);
        float f = fails / tries;
        System.out.println(f + "% of errors");
    }

    public static int DoTheJob() {
        Counter counter = new Counter();

        Thread t1 = new Thread(counter::increment);
        Thread t2 = new Thread(counter::increment);

        t1.start();
        t2.start();

        ExecutorService threadPool = Executors.newFixedThreadPool(2);
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

        return counter.getCounter();
    }
}

class Counter {
    private int counter;

    public synchronized void increment() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }
}