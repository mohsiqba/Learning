package com.mohsin.learning.Array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author : m0i005b (mohsin.iqbal@walmart.com)
 * Date : 05-Jul-2021
 * Description :
 */
public class ShortestSubArrayWithNegativeIntegers {

    public static void main(String[] args) {
        System.out.println(shortestSubarray(new int[]{84,-37,32,40,95},167));
    }


    public static int shortestSubarray(int[] A, int K) {
        int N = A.length, res = N + 1;
        int[] B = new int[N + 1];
        for (int i = 0; i < N; i++) B[i + 1] = B[i] + A[i];
        System.out.println(Arrays.toString(B));
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < N + 1; i++) {
            System.out.println("i:"+i);
            while (d.size() > 0 && B[i] - B[d.getFirst()] >=  K){
                System.out.println("d1:"+d);
                res = Math.min(res, i - d.pollFirst());
                System.out.println("d2:"+d);
                System.out.println("res2:"+res);
            }
            while (d.size() > 0 && B[i] <= B[d.getLast()]){
                System.out.println("d3:"+d);
                d.pollLast();
                System.out.println("d4:"+d);
            }
            System.out.println("d5:"+d);
            d.addLast(i);
            System.out.println("d6:"+d);
        }
        return res <= N ? res : -1;
    }

}
