package com.mohsin.learning.Array.DP;

import java.util.*;

/**
 * @author : m0i005b (mohsin.iqbal@walmartlabs.com)
 * Date : 13-May-2021
 * Description :
 */
public class HowSum {

    public static void main(String[] args) {
        System.out.println(howSum(new int[]{2,3},7));
        System.out.println(howSum(new int[]{5,3,4,7},7));
        System.out.println(howSum(new int[]{2,4},7));
        System.out.println(howSum(new int[]{2,3,5},8));
        System.out.println(howSum(new int[]{7,14},300));
        System.out.println("----------------");
        System.out.println(howSumDP(new int[]{2,3},7,new HashMap<>()));
        System.out.println(howSumDP(new int[]{5,3,4,7},7,new HashMap<>()));
        System.out.println(howSumDP(new int[]{2,4},7,new HashMap<>()));
        System.out.println(howSumDP(new int[]{2,3,5},8,new HashMap<>()));
        System.out.println(howSumDP(new int[]{7,14},300,new HashMap<>()));
    }

    public static List<Integer> howSumDP(int[] nums, int target, Map<Integer,List<Integer>> memo){
        if(target < 0) {
            return null;
        }
        if( memo.containsKey(target)){
            return memo.get(target);
        }
        if(target==0) {
            return new ArrayList();
        }
        for (int n:nums){
            List<Integer> list=howSumDP(nums,target-n,memo);
            if(list!=null){
                List list1=new ArrayList(){{addAll(list);}};
                list1.add(n);
                memo.put(target,list1);
                return list1;
            }
        }
        memo.put(target,null);
        return memo.get(target);
    }

    public static List<Integer> howSum(int[] nums, int target){
        if(target==0)
            return new ArrayList();

        if(target < 0)
            return null;

        for (int n:nums){
            List<Integer> list=howSum(nums,target-n);
            if(list!=null){
                list.add(n);
                return list;
            }
        }
        return null;
    }
}
