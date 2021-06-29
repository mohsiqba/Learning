package com.mohsin.learning.pointers2;

import java.util.Arrays;

/**
 * @author : m0i005b (mohsin.iqbal@walmartlabs.com)
 * Date : 17-May-2021
 * Description :
 */
public class DutchNationalFlagProblem {
    public static void main(String[] args) {
        dutchNationalFlagProblem(new int[]{1, 0, 2, 1, 0});
        dutchNationalFlagProblem(new int[]{2, 2, 0, 1, 2, 0});
    }

    static void dutchNationalFlagProblem(int[] arr){
        int left=0,right= arr.length-1;
        for (int i = 0; i <=right;) {
            if(arr[i]==0){
                swap(arr,i,left);
                i++;
                left++;
            } else if(arr[i]==1){
                i++;
            } else {
                swap(arr,i,right);
                right--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

}
