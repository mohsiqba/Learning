package com.mohsin.learning;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : m0i005b (mohsin.iqbal@walmartlabs.com)
 * Date : 20-May-2021
 * Description :
 */
public class Permutations {

    public static void main(String[] args) {
        Permutations permutations=new Permutations();
        System.out.println(permutations.permuteUniqueElement(new int[]{1,2,3}));
        System.out.println(permutations.getPermutation(3,2));

    }

    private int count=0;
    private String resultStr="";
    public String getPermutation(int n, int k) {
        String str="";
        List<List<Integer>> result=new ArrayList<>();
        permute(n,k,new ArrayList<>(),result,str);
        System.out.println(result);
        return "";

    }
    void permute(int n, int k, List<Integer> temp, List<List<Integer>> result,String str){
        if(temp.size()==k){
            result.add(new ArrayList<>(temp));
            count++;
            return;
        }
        for(int i=1;i<=n;i++){
            if(temp.contains(i)) continue;
            temp.add(i);
            str=str.concat(String.valueOf(i));
            permute(n,k,temp,result,str);
//            if(count==k){
//                resultStr=str;
//                return;
//            }

            temp.remove(temp.size()-1);
            str=str.substring(0,str.length()-1);
        }
    }

    public List<List<Integer>> permuteUniqueElement(int[] nums){
        List<Integer> tempList=new ArrayList<>();
        List<List<Integer>> resultList= new ArrayList<>();
        permuteUniqueElementBacktrack(nums,tempList,resultList);
        return resultList;
    }
    public void permuteUniqueElementBacktrack(int[] nums, List<Integer> tempList, List<List<Integer>> resultList){
        if(tempList.size()== nums.length){
            resultList.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (tempList.contains(nums[i])) continue;
            tempList.add(nums[i]);
            permuteUniqueElementBacktrack(nums,tempList,resultList);
            tempList.remove(tempList.size()-1);
        }
    }
}
