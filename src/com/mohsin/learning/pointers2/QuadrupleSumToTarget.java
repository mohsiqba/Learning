package com.mohsin.learning.pointers2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : m0i005b (mohsin.iqbal@walmartlabs.com)
 * Date : 17-May-2021
 * Description :
 */
public class QuadrupleSumToTarget {
    public static void main(String[] args) {
        System.out.println(quadrupleSumToTarget(new int[]{4, 1, 2, -1, 1, -3},1));
        System.out.println(quadrupleSumToTarget(new int[]{2, 0, -1, 1, -2, 2},2));
        System.out.println(quadrupleSumToTarget(new int[]{2, 2, 2, 2, 2},8));
    }

    static List<List<Integer>> quadrupleSumToTarget(int[] arr, int target){
        Arrays.sort(arr);
        List<List<Integer>> res=new ArrayList<>();
        for (int i = 0; i < arr.length-3; i++) {
            if(i>0 && arr[i]==arr[i-1]){
                continue;
            }
            for (int j = i+1; j < arr.length-2; j++) {
                if(j>i+1 && arr[j]==arr[j-1]){
                    continue;
                }
                search(arr,target,i,j,res);
            }
        }
        return res;
    }

    private static void search(int[] arr, int target, int i, int j,List<List<Integer>> res) {
        int left=j+1,right= arr.length-1;
        while (left<right){
            int sum=arr[i]+arr[j]+arr[left]+arr[right];
            if(sum==target){
                res.add(Arrays.asList(arr[i],arr[j],arr[left],arr[right]));
                left++;
                right--;
                while (left<right && arr[left]==arr[left-1]){
                    left++;
                }
                while (left<right && arr[right]==arr[right+1]){
                    right--;
                }
            } else if(sum<target){
                left++;
            } else {
                right--;
            }
        }
    }
}
