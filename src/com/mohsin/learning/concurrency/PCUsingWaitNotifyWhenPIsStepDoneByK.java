package com.mohsin.learning.concurrency;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : Mohsin Iqbal
 * Date : 21-Jun-2021
 * Description :
 */

/**
 * k=1 => produce/consumer in synchronous way
 * -1  => KILL-CONSUMER-THREAD
 */
public class PCUsingWaitNotifyWhenPIsStepDoneByK {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Producer producer = new Producer(1, queue);
        Consumer consumer = new Consumer(queue);
        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();
        producerThread.start();
    }

    static class Producer implements Runnable {
        int k;
        Queue<Integer> queue;

        Producer(int k, Queue<Integer> queue) {
            this.k = k;
            this.queue = queue;
        }

        public void run() {
            try {
                System.out.println("Producer ready to produce.");
                for (int i = 0; i < 10; i++) {
                    synchronized (queue) {
                        while (queue.size() == k) {
                            System.out.println("Producer already produced k items. waiting for consumer to consume...");
                            queue.wait();
                        }
                    }
                    synchronized (queue) {
                        System.out.println("Produced-" + i);
                        queue.add(i);
                        Thread.sleep(1000);
                        if (queue.size() == k) {
                            queue.notify();
                        }
                    }
                }
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            } finally {
                queue.add(-1);
            }
        }
    }

    static class Consumer implements Runnable {
        Queue<Integer> queue;

        Consumer(Queue<Integer> queue) {
            this.queue = queue;
        }

        public void run() {
            try {
                while (true) {
                    System.out.println("Consumer ready to consumer...");
                    synchronized (queue) {
                        while (queue.size() == 0) {
                            System.out.println("Consumer already consumed.waiting for producer to produce...");
                            queue.wait();
                        }
                    }
                    synchronized (queue) {
                        int element=queue.remove();
                        if (element==-1) break;
                        System.out.println("Consumed-" + element);
                        Thread.sleep(1500);
                        queue.notify();
                    }
                }
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }
}
