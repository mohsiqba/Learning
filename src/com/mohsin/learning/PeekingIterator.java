package com.mohsin.learning;

import java.util.Iterator;

/**
 *
 * @param <T>
 */
class PeekingIterator<T> implements Iterator<T> {
	T next;
	boolean noElement;
	Iterator<T> iter;
	public PeekingIterator(Iterator<T> iterator) {
	    // initialize any member here.
	    iter=iterator;
	    advanceItr();
	}

	private void advanceItr() {
		if(iter.hasNext()){
			next=iter.next();
		} else {
			noElement=true;
		}
	}

	// Returns the next element in the iteration without advancing the iterator.
	public T peek() {
        return next;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public T next() {
	    if(noElement){
	    	return null;
		}
	    T res=next;
	    advanceItr();
	    return res;
	}
	
	@Override
	public boolean hasNext() {
	    return !noElement;
	}
}