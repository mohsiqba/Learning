package com.mohsin.learning.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author : Mohsin Iqbal
 * Date : 22-Jun-2021
 * Description :
 */
public class PCUsingBlockingQueue {

    static class Producer implements Runnable{
        BlockingQueue<Integer> queue;
        Producer(BlockingQueue<Integer> queue){
            this.queue=queue;
        }
        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    queue.put(i);
                    System.out.println("Produced-"+i);
                    Thread.sleep(500);
                }
                queue.put(-1);
            } catch (InterruptedException interruptedException){
                interruptedException.printStackTrace();
            }
        }
    }

    static class Consumer implements Runnable{
        BlockingQueue<Integer> queue;
        Consumer(BlockingQueue<Integer> queue){
            this.queue=queue;
        }

        @Override
        public void run() {
            try {
                while (true){
                    Integer item= queue.take();
                    if (item==-1){
                        break;
                    }
                    System.out.println("Consumed-"+item);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException interruptedException){
                interruptedException.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        BlockingQueue<Integer> queue=new LinkedBlockingQueue<>(2);
        Producer producer=new Producer(queue);
        Consumer consumer=new Consumer(queue);
        Thread t1=new Thread(producer);
        Thread t2=new Thread(consumer);
        t1.start();
        t2.start();
    }
}
