package com.mohsin.learning.pointers2;

import java.util.Arrays;

/**
 * @author : m0i005b (mohsin.iqbal@walmartlabs.com)
 * Date : 17-May-2021
 * Description :
 */
public class SquaringSortedArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(squaringSortedArray(new int[]{-2, -1, 0, 2, 3})));
    }

    public static int[] squaringSortedArray(int[] arr){
        int[] res=new int[arr.length];
        int right= arr.length-1;
        int low=0,high= arr.length-1;
        while(low<high){
            if(Math.pow(arr[low],2)<Math.pow(arr[high],2)){
                res[right--]= (int) Math.pow(arr[high--],2);
            } else {
                res[right--]= (int) Math.pow(arr[low++],2);
            }
        }
        return  res;
    }
}
