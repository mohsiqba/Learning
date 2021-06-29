package com.mohsin.learning.pointers2;

/**
 * @author : m0i005b (mohsin.iqbal@walmartlabs.com)
 * Date : 17-May-2021
 * Description :
 */
public class MinimumWindowSort {
    public static void main(String[] args) {
        System.out.println(minimumWindowSort(new int[]{1, 2, 5, 3, 7, 10, 9, 12}));
        System.out.println(minimumWindowSort(new int[]{1, 3, 2, 0, -1, 7, 10}));
        System.out.println(minimumWindowSort(new int[]{1, 2, 3}));
        System.out.println(minimumWindowSort(new int[]{3, 2, 1}));
    }

    static int minimumWindowSort(int[] arr){
        //find left out of sync idx
        //find right out of sync idx
        //between left and right is the probable subarray
        //find max and min between left and right idx
        //lower left idx based on min
        //higher right idx based on max
        //return right-left+1 as length of the array.

        int left=0,right= arr.length-1;
        while(left< arr.length-1 && arr[left]<=arr[left+1]){
            left++;
        }
        if(left == arr.length-1) return 0;

        while (right>0 && arr[right]>=arr[right-1]){
            right--;
        }

        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        for (int i = left; i <=right; i++) {
            max=Math.max(max,arr[i]);
            min=Math.min(min,arr[i]);
        }

        while(left>0 && arr[left-1]>min){
            left--;
        }
        while (right< arr.length-1 && max>arr[right+1]){
            right++;
        }
        return right-left+1;
    }
}
