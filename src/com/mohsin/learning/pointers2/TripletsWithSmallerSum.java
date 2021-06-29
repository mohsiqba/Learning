package com.mohsin.learning.pointers2;

import java.util.Arrays;

/**
 * @author : m0i005b (mohsin.iqbal@walmartlabs.com)
 * Date : 17-May-2021
 * Description :
 */
public class TripletsWithSmallerSum {
    public static void main(String[] args) {
        System.out.println(tripletsWithSmallerSum(new int[]{-1, 0, 2, 3},3));
        System.out.println(tripletsWithSmallerSum(new int[]{-1, 4, 2, 1, 3},5));
    }

    static int tripletsWithSmallerSum(int[] arr,int target){
        int count=0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length-2; i++) {
            count+=searchPair(arr,i,target);
        }
        return count;
    }

    private static int searchPair(int[] arr, int i, int target) {
        int left=i+1,right= arr.length-1;
        int count=0;
        while(left<right){
            if(arr[left]+arr[right]+arr[i]<target){
                left++;
                count+=right-left+1;
            } else {
                right--;
            }
        }
        return count;
    }
}
