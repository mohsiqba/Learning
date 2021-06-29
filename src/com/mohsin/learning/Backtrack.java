package com.mohsin.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : m0i005b (mohsin.iqbal@walmartlabs.com)
 * Date : 20-May-2021
 * Description :
 */
public class Backtrack {

    public static void main(String[] args) {
        Backtrack backtrack=new Backtrack();


        System.out.println(backtrack.allSubsetsWithUniqueElement(new int[]{3,2,1}));
        System.out.println(backtrack.allSubsetsWithDuplicatesElement(new int[]{1,2,2}));

    }
    public List<List<Integer>> allSubsetsWithUniqueElement(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        allSubsetsWithUniqueElementBacktrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void allSubsetsWithUniqueElementBacktrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            allSubsetsWithUniqueElementBacktrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public List<List<Integer>> allSubsetsWithDuplicatesElement(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        allSubsetsWithDuplicatesElementBacktrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void allSubsetsWithDuplicatesElementBacktrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            if(i>start && nums[i]==nums[i-1]) continue; //skip duplicates
            tempList.add(nums[i]);
            allSubsetsWithDuplicatesElementBacktrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
