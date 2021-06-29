package com.mohsin.learning.Array.DP;

/**
 * @author : m0i005b (mohsin.iqbal@walmartlabs.com)
 * Date : 13-May-2021
 * Description :
 */
public class CanSum {

    public static void main(String[] args) {
        System.out.println(canSum(new int[]{2,3},7));
        System.out.println(canSum(new int[]{5,3,4,7},7));
        System.out.println(canSum(new int[]{2,4},7));
        System.out.println(canSum(new int[]{2,3,5},8));
        System.out.println(canSum(new int[]{7,14},300));
        System.out.println("-----------------");
        System.out.println(canSumDP(new int[]{2,3},7, new Boolean[8]));
        System.out.println(canSumDP(new int[]{5,3,4,7},7,new Boolean[8]));
        System.out.println(canSumDP(new int[]{2,4},7,new Boolean[8]));
        System.out.println(canSumDP(new int[]{2,3,5},8,new Boolean[9]));
        System.out.println(canSumDP(new int[]{7,14},300,new Boolean[301]));
    }

    public static boolean canSumDP(int[] nums,int target, Boolean[] memo){
        if(target<0){
            return false;
        }if(memo[target]!=null){
            return memo[target];
        }
        if (target==0){
            return true;
        }

        for (int n: nums){
            if(canSumDP(nums,target-n, memo)){
                memo[target]=true;
                return true;
            }
        }
        memo[target]=false;
        return memo[target];
    }

    public static boolean canSum(int[] nums,int target){
        if (target==0){
            return true;
        }
        if(target<0){
            return false;
        }
        for (int n: nums){
             if(canSum(nums,target-n)){
                 return true;
             }
        }
        return false;
    }
}
