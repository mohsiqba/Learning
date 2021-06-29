package com.mohsin.learning.design;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * https://www.lintcode.com/problem/528/description
 * 528 · Flatten Nested List Iterator
 */
public class NestedIterator implements Iterator<Integer> {

    Stack<Iterator<NestedInteger>> stack;
    Integer next;
    public NestedIterator(List < NestedInteger > nestedList) {
        // Initialize your data structure here.
        Iterator<NestedInteger> it = nestedList.iterator();
        stack = new Stack();
        stack.push(it);
        findNext();
    }

    void findNext () {
        next = null;
        while (!stack.isEmpty()) {
            Iterator<NestedInteger> it = stack.peek();
            if (!it.hasNext()) {
                stack.pop();
                continue;
            }
            NestedInteger ni = it.next();
            if (ni.isInteger()) {
                next = ni.getInteger();
                break;
            }
            stack.push(ni.getList().iterator());
        }
    }
    // @return {int} the next element in the iteration
    @Override
    public Integer next () {
        // Write your code here
        if (next == null)
            return null;
        Integer res = next;
        findNext();
        return res;
    }

    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext () {
        // Write your code here
        if (next == null)
            return false;
        return true;
    }

    @Override
    public void remove () {
    }
}