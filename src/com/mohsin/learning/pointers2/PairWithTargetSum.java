package com.mohsin.learning.pointers2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : m0i005b (mohsin.iqbal@walmartlabs.com)
 * Date : 17-May-2021
 * Description :
 */
public class PairWithTargetSum {

    /**
     * Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.
     * Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(pairWithTargetSum(new int[]{1,2,3,4,6},6)));
        System.out.println(Arrays.toString(pairWithTargetSum(new int[]{2,5,9,11},11)));
        System.out.println(Arrays.toString(pairWithTargetSum(new int[]{2,5,9,11},12)));
        System.out.println("---------------------");
        System.out.println(allPairsWithTargetSum(new int[]{0,2,3,4,6},6));
        System.out.println(allPairsWithTargetSum(new int[]{2,5,9,11},11));
        System.out.println(allPairsWithTargetSum(new int[]{2,5,9,11},12));
    }

    public static int[] pairWithTargetSum(int[] arr, int target){
        int left=0,right=arr.length-1;
        while(left<right){
            if(arr[left]+arr[right]==target){
                return new int[]{left,right};
            }else if(arr[left]+arr[right]<target){
                left++;
            } else{
                right--;
            }
        }
        return new int[]{};
    }

    static class Pair{
        int left;
        int right;
        Pair(int left,int right){
            this.left=left;
            this.right=right;
        }

        @Override
        public String toString() {
            return new StringBuffer().append(left).append(",").append(right).toString();
        }
    }
    public static List<Pair> allPairsWithTargetSum(int[] arr, int target){
        List<Pair> result=new ArrayList<>();
        int left=0,right=arr.length-1;
        while(left<right){
            if(arr[left]+arr[right]==target){
                result.add(new Pair(left,right));
                left++;
                right--;
            }else if(arr[left]+arr[right]<target){
                left++;
            } else{
                right--;
            }
        }
        return result;
    }
}
