package threadsdeom;

import java.util.concurrent.*;

/**
 * Created by meltzer on 13.02.17.
 */
public class ThreadClass {
    public static void main(String[] args) {
        //Basic thread exapmle
        /*
        Thread t = new Thread(
                () -> {while (true) System.out.println("111"); }
        );
        t.start();
        while(true) System.out.println("222");
        */

        //ThreadPool example

        ExecutorService pool = Executors.newFixedThreadPool(4);
        pool.execute(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        pool.execute(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        //WITH RETURN!
        Future<Integer> future = pool.submit(() -> {
            return 5;
        });
        future.isDone(); //check if done
        try {
            future.get(); //wait for result
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
