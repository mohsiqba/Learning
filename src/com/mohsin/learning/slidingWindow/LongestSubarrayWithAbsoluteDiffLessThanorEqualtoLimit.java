package com.mohsin.learning.slidingWindow;

/**
 * @author : m0i005b (mohsin.iqbal@walmartlabs.com)
 * Date : 24-May-2021
 * Description :
 */
public class LongestSubarrayWithAbsoluteDiffLessThanorEqualtoLimit {

    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{10,1,2,4,7,2},5));
    }
    public static int longestSubarray(int[] nums, int limit) {
        int windowStart=0,windowEnd=0,max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        int maxLen=0;
        for(windowEnd=0;windowEnd<nums.length;windowEnd++){
            max=Math.max(max,nums[windowEnd]);
            min=Math.min(min,nums[windowEnd]);
            if(Math.abs(Math.subtractExact(max,min))>limit){
                maxLen=Math.max(maxLen,windowEnd-windowStart+1);
                windowStart++;
                max=Math.max(max,nums[windowStart]);
                min=Math.min(min,nums[windowStart]);
            }
        }
        return maxLen;
    }
}
