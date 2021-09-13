package com.mohsin.lld.ratelimiter.v4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Driver {

    RateLimiter rateLimiter = new FixedWindowRateLimiterWindow(new TimeWindow(2, TimeUnit.SECONDS), 5);

    private class Work {

        public void doWork(String eid) {

            if (rateLimiter.check(eid)) {
                try {

                    System.out.println("doing work " + System.currentTimeMillis());
                    Thread.sleep(500);
                    System.out.println("done work " + System.currentTimeMillis());

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Not allowed/Rate limited");
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {

        Driver driver = new Driver();
        driver.test();

    }

    private void test() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {

            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    Work work = new Work();
                    work.doWork("eid");
                }
            });
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}














