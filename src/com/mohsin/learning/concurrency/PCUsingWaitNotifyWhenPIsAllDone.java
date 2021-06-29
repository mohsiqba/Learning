package com.mohsin.learning.concurrency;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : m0i005b (mohsin.iqbal@walmart.com)
 * Date : 21-Jun-2021
 * Description :
 */
public class PCUsingWaitNotifyWhenPIsAllDone {

    static class Producer implements Runnable{
        Queue<Integer> queue;
        Producer(Queue<Integer> queue){
            this.queue=queue;
        }
        public void run(){
            try {
                synchronized (this){
                    System.out.println("Producer thread ready to produce.");
                    for (int i = 0; i < 10; i++) {
                        queue.add(i);
                        System.out.println("Produced-"+i);
                        Thread.sleep(1000);
                    }
                    System.out.println("Producer done!!!");
                    this.notify();
                }
            } catch (InterruptedException interruptedException){
                interruptedException.printStackTrace();
            }
        }
    }

    static class Consumer implements Runnable{
        Producer producer;
        Consumer(Producer producer){
            this.producer=producer;
        }
        public void run(){
            try {
                synchronized (this.producer){
                    System.out.println("Consumer waiting for Producer to be done!!");
                    this.producer.wait();
                }
                int size=this.producer.queue.size();
                for (int i = 0; i < size; i++) {
                    System.out.println("Consumed-"+this.producer.queue.remove());
                    Thread.sleep(500);
                }
                System.out.println("Consumer done !!!");
            } catch (InterruptedException interruptedException){
                interruptedException.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue=new LinkedList<>();
        Producer producer=new Producer(queue);
        Thread producerThread=new Thread(producer);
        Consumer consumer=new Consumer(producer);
        Thread consumerThread=new Thread(consumer);

        consumerThread.start();
        producerThread.start();

    }
}
