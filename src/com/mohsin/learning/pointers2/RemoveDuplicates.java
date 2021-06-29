package com.mohsin.learning.pointers2;

import java.util.Arrays;

/**
 * @author : m0i005b (mohsin.iqbal@walmartlabs.com)
 * Date : 17-May-2021
 * Description :
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{2, 3, 3, 3, 6, 9, 9}));
        System.out.println(removeDuplicates(new int[]{2,2,2, 11}));
    }

    public static int removeDuplicates(int[] arr){
        int idx=1,cpyPtr=0;
        while(idx<arr.length){
            if(arr[idx]==arr[idx-1]){
                idx++;
            }else{
                arr[cpyPtr++]=arr[idx++];
            }
        }
        System.out.println(Arrays.toString(arr));
        return cpyPtr+1;
    }
}
