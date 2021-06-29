package com.mohsin.learning.Array.DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : m0i005b (mohsin.iqbal@walmartlabs.com)
 * Date : 13-May-2021
 * Description :
 */
public class BestSum {

    public static void main(String[] args) {
        System.out.println(bestSum(new int[]{2,3},7));
        System.out.println(bestSum(new int[]{5,3,4,7},7));
        System.out.println(bestSum(new int[]{2,4},7));
        System.out.println(bestSum(new int[]{2,3,5},8));
        System.out.println(bestSum(new int[]{10,20,25},500));
        System.out.println("----------------");
        System.out.println(bestSumDP(new int[]{2,3},7, new HashMap<>()));
        System.out.println(bestSumDP(new int[]{5,3,4,7},7, new HashMap<>()));
        System.out.println(bestSumDP(new int[]{2,4},7, new HashMap<>()));
        System.out.println(bestSumDP(new int[]{2,3,5},8, new HashMap<>()));
        System.out.println(bestSumDP(new int[]{10,20,25},500, new HashMap<>()));
    }

    public static List bestSumDP(int[] nums, int target, Map<Integer,List> memo){
//        System.out.println("memo = " + memo);
        if(memo.containsKey(target)){
//            System.out.println("get:"+memo.get(target));
            return memo.get(target);
        }
        if(target==0){
            return new ArrayList();
        }
        if(target<0){
            return null;
        }
        List bestList=null;
        for(int num:nums){
            List list=bestSumDP(nums,target-num,memo);
            if(list!=null){
                List list1=new ArrayList(){{addAll(list);}};
                list1.add(num);
                if(bestList==null || list1.size()<bestList.size()){
                    bestList=list1;
                }
            }
        }
        memo.put(target, bestList);
//        System.out.println("memo = " + memo);
        return bestList;
    }

    public static List bestSum(int[] nums, int target){
        if(target==0){
            return new ArrayList();
        }
        if(target<0){
            return null;
        }
        List bestList=null;
        for(int num:nums){
            List list=bestSum(nums,target-num);
            if(list!=null){
                list.add(num);
                if(bestList==null || list.size()<bestList.size()){
                    bestList=list;
                }
            }
        }
        return bestList;
    }
}
