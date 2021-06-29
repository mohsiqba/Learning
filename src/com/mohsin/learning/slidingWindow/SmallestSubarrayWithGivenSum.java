package com.mohsin.learning.slidingWindow;

/**
 * @author : m0i005b (mohsin.iqbal@walmartlabs.com)
 * Date : 14-May-2021
 * Description :
 */
public class SmallestSubarrayWithGivenSum {

    public static int smallestSubarrayWithGivenSum(int[] nums,int sum){
        int windowStart=0,windowEnd=0,windowSum=0,windowLength=Integer.MAX_VALUE;
        for (windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            windowSum+=nums[windowEnd];
            while (windowSum>=sum){
                windowLength=Math.min(windowLength,windowEnd-windowStart+1);
                windowSum-=nums[windowStart];
                windowStart++;
            }
        }
        return windowLength == Integer.MAX_VALUE?0:windowLength;
    }
    public static void main(String[] args) {
        System.out.println(smallestSubarrayWithGivenSum(new int[]{2,1,5,2,3,2},7));
    }
}
