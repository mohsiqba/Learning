package com.mohsin.learning.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : m0i005b (mohsin.iqbal@walmartlabs.com)
 * Date : 23-May-2021
 * Description :
 * ensure cycle's length > 1
 * ensure single direction
 */

public class CircularArrayLoop {
    public static void main(String[] args) {
        CircularArrayLoop loop=new CircularArrayLoop();
        System.out.println("-------------using map/recursion-----------");
        System.out.println(loop.usingMap(new int[]{2,-1,1,2,2}));
        System.out.println(loop.usingMap(new int[]{-1,2}));
        System.out.println(loop.usingMap(new int[]{-2,1,-1,-2,-2}));

        System.out.println("-------------using fast/slow ptr-----------");
        System.out.println(loop.usingSlowFastPtr(new int[]{2,-1,1,2,2}));
        System.out.println(loop.usingSlowFastPtr(new int[]{-1,2}));
        System.out.println(loop.usingSlowFastPtr(new int[]{-2,1,-1,-2,-2}));
    }
    
    boolean usingMap(int[] nums){
        Map<Integer,Boolean> map=new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if(isCycleExists(nums,i,map)){
                return true;
            }
        }
        return false;
    }

    private boolean isCycleExists(int[] nums, int idx, Map<Integer, Boolean> map) {
        if(map.containsKey(idx)){
            return map.get(idx);
        }
        map.put(idx,true);
        int next=getIdx(idx,nums);
        if(next!=idx && nums[next]*nums[idx]>0){
            if(isCycleExists(nums,next,map)){
                return true;
            }
        }
        map.put(idx,false);
        return false;
    }


    boolean usingSlowFastPtr(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int slow=i,fast=getIdx(i,nums);
            while(nums[i]*nums[fast]>0 && nums[i]*nums[getIdx(fast,nums)]>0){
                if(slow==fast){
                    if(slow==getIdx(slow,nums)){
                        break;
                    }
                    return true;
                }
                slow=getIdx(slow,nums);
                fast=getIdx(getIdx(fast,nums),nums);
            }
            slow=i;
            while (nums[i]*nums[slow]>0){
                int temp=getIdx(slow,nums);
                nums[slow]=0;
                slow=temp;
            }
        }
        return false;
    }

    private int getIdx(int idx, int[] nums) {
        //same as return
//        Math.floorMod((idx+nums[idx]), nums.length);
        return (idx+nums[idx])>0?(idx+nums[idx])% nums.length: (nums.length+((idx+nums[idx])% nums.length))%nums.length;
    }
}
