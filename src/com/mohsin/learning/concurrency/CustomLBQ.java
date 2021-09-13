package com.mohsin.learning.concurrency;

import java.util.LinkedList;
import java.util.List;

/**
 * @author : Mohsin Iqbal
 * Date : 22-Jun-2021
 * Description :
 */
public class CustomLBQ<E> implements ICustomBQ<E>{

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
