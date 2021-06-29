package com.mohsin.learning.concurrency;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

/**
 * @author : m0i005b (mohsin.iqbal@walmart.com)
 * Date : 22-Jun-2021
 * Description :
 */
public class PCUsingCustomLBQ {
    interface ICustomBQ<E> {
        void put(E item) throws InterruptedException;
        E take() throws InterruptedException;
    }
    static class CustomLBQ<E> implements ICustomBQ<E> {

        private List<E> queue;
        private int maxSize;

        public CustomLBQ(int maxSize) {
            this.queue = new LinkedList<E>();
            this.maxSize = maxSize;
        }

        @Override
        public synchronized void put(E item) throws InterruptedException {
            while (queue.size()==maxSize)
                this.wait();
            queue.add(item);
            this.notifyAll();
        }

        @Override
        public synchronized E take() throws InterruptedException {
            while (queue.isEmpty())
                this.wait();
            this.notifyAll();
            return queue.remove(0);
        }
    }
    static class Producer implements Runnable {
        ICustomBQ<Integer> lbq;

        Producer(ICustomBQ<Integer> lbq) {
            this.lbq = lbq;
        }

        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Produced-" + i);
                    lbq.put(i);
                    Thread.sleep(500);
                }
                lbq.put(-1);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }

    static class Consumer implements Runnable {
        ICustomBQ<Integer> lbq;

        Consumer(ICustomBQ<Integer> lbq) {
            this.lbq = lbq;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Integer item = lbq.take();
                    if (item == -1) {
                        break;
                    }
                    System.out.println("Consumed-" + item);
                    Thread.sleep(1000);

                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ICustomBQ<Integer> customBQ = new CustomLBQ<>(2);
        Producer producer = new Producer(customBQ);
        Consumer consumer = new Consumer(customBQ);
        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();
        producerThread.start();
        Thread.sleep(2000);
    }
}
