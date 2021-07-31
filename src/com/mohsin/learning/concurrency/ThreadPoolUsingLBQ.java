package com.mohsin.learning.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author : m0i005b (mohsin.iqbal@walmart.com)
 * Date : 22-Jun-2021
 * Description :
 */
public class ThreadPoolUsingLBQ {
    public static void main(String[] args) throws InterruptedException {
//        Thread thread1=new Thread(new Task(),"thread1");
//        Thread thread2=new Thread(new Task(),"thread2");

        Runnable thread1=new Task();
        Runnable thread2=new Task();
        ThreadPool threadPool=new ThreadPool(2);
        threadPool.execute(thread1);
        threadPool.execute(thread2);
        threadPool.shutdown();
        threadPool.execute(thread2);
        threadPool.execute(thread2);
    }

    static class WorkerThread extends Thread{
        ThreadPool threadPool;
        WorkerThread(ThreadPool threadPool){
            this.threadPool=threadPool;
        }

        @Override
        public void run() {
            try {
                while (true){
                    Runnable runnable=threadPool.queue.take();
                    runnable.run();
                    if (this.threadPool.isShutdownInitialized() && threadPool.queue.size()==0) {
                        Thread.currentThread().interrupt();
                        Thread.sleep(1000);
                    }
                }
            } catch (InterruptedException interruptedException){
                interruptedException.printStackTrace();
            }

        }
    }

    static class ThreadPool {
        private BlockingQueue<Runnable> queue=null;
        private Boolean isShutdownInitialized=Boolean.FALSE;

        ThreadPool(int maxThread){
            queue=new LinkedBlockingQueue<>(maxThread);

            for (int i = 0; i < maxThread; i++) {
                Thread workerThread=new WorkerThread(this);
                workerThread.setName("WorkerThread-"+i);
                workerThread.start();
                System.out.println("WorkerThread-"+i+" Started");
            }
        }

        public synchronized void execute(Runnable task) throws InterruptedException{
            if (isShutdownInitialized) {
                System.out.println("Shutdown initialized...No new task submitted");
                return;
            }
            System.out.println("Task Submitted");
            queue.put(task);
        }

        public synchronized void shutdown(){
            System.out.println("Shutdown Initialized");
            this.isShutdownInitialized=true;
        }

        public Boolean isShutdownInitialized() {
            return isShutdownInitialized;
        }
    }

    static class Task implements Runnable{
        @Override
        public void run() {
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName()+" |executed i:"+i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException interruptedException){
                interruptedException.printStackTrace();
            }
        }
    }
}
