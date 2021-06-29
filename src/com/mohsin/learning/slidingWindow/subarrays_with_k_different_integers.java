package com.mohsin.learning.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : m0i005b (mohsin.iqbal@walmart.com)
 * Date : 24-May-2021
 * Description :
 */
/*
exactly(K) = atMost(K) - atMost(K-1)
 */
public class subarrays_with_k_different_integers {
    public static void main(String[] args) {
        System.out.println(atMostK(new int[]{1,2,1,2,3},2));
        System.out.println(atMostK(new int[]{1,2,1,2,3},1));
        System.out.println(atMostK(new int[]{1,2,3,1,4,3,1,3,1,3,1,3,1},3));
        System.out.println(atMostK(new int[]{1,2,3,1,4,3,1,3,1,3,1,3,1},2));
    }

    static int atMostK(int[] A, int K) {
        int i = 0, res = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int j = 0; j < A.length; ++j) {
            if (count.getOrDefault(A[j], 0) == 0) K--;
            count.put(A[j], count.getOrDefault(A[j], 0) + 1);
            while (K < 0) {
                count.put(A[i], count.get(A[i]) - 1);
                if (count.get(A[i]) == 0) K++;
                i++;
            }
            res += j - i + 1;
        }
        return res;
    }
}
