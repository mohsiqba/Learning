package com.mohsin.learning.concurrency;

/**
 * @author : m0i005b (mohsin.iqbal@walmart.com)
 * Date : 22-Jun-2021
 * Description :
 */
public interface ICustomBQ<E> {
    void put(E item) throws InterruptedException;
    E take() throws InterruptedException;
}
