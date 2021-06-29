package com.mohsin.learning.slidingWindow;

/**
 * @author : m0i005b (mohsin.iqbal@walmartlabs.com)
 * Date : 14-May-2021
 * Description :
 */
public class MaximumSumSubarrayOfSizeK {
    public static int maximumSumSubarrayOfSizeK(int[] nums, int k){
        int windowStart=0,windowEnd=0,windowSum=0,maxSum=0;
        for (windowEnd=0;windowEnd<nums.length;windowEnd++){
            windowSum+=nums[windowEnd];
            if(windowEnd>=k-1){
               maxSum=Math.max(windowSum,maxSum);
               windowSum-=nums[windowStart];
               windowStart++;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maximumSumSubarrayOfSizeK(new int[]{2,1,5,1,3,2},3));
        System.out.println(maximumSumSubarrayOfSizeK(new int[]{2,3,4,1,5},2));
    }
}
