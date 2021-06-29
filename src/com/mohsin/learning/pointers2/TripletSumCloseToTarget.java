package com.mohsin.learning.pointers2;

import java.util.Arrays;

/**
 * @author : m0i005b (mohsin.iqbal@walmartlabs.com)
 * Date : 17-May-2021
 * Description :
 */
public class TripletSumCloseToTarget {
    public static void main(String[] args) {
        System.out.println(tripletSumCloseToTarget(new int[]{-2, 0, 1, 2},2));
        System.out.println(tripletSumCloseToTarget(new int[]{-3, -1, 1, 2},1));
        System.out.println(tripletSumCloseToTarget(new int[]{1, 0, 1, 1},100));
    }

    static int tripletSumCloseToTarget(int[] nums, int target){
        Arrays.sort(nums);
        int smallestDiff=Integer.MAX_VALUE;
        for(int i=0;i<nums.length-2;i++){
            int left=i+1,right=nums.length-1;
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(Math.abs(target-sum)==0){
                    return sum;
                }
                if(Math.abs(target-sum)<Math.abs(smallestDiff)){
                    smallestDiff=target-sum;
                }
                if(sum<target){
                    left++;
                } else{
                    right--;
                }
            }
        }
        return target-smallestDiff;
    }
}
