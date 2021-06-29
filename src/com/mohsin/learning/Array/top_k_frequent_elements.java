package com.mohsin.learning.Array;

import java.util.*;

/**
 * @author : m0i005b (mohsin.iqbal@walmart.com)
 * Date : 28-May-2021
 * Description :
 */
public class top_k_frequent_elements {

    public static void main(String[] args) {
        top_k_frequent_elements ele=new top_k_frequent_elements();
        System.out.println(ele.topKFrequentArray(new int[]{1,1,2,2,3},1));
        System.out.println(ele.topKFrequentMaxHeap(new int[]{1,1,1,2,2,3},2));
        System.out.println(ele.topKFrequentTreeMap(new int[]{1,1,1,2,2,3},2));

    }

    public List<Integer> topKFrequentArray(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //use array
        List<Integer>[] arr=new List[map.size()+1];
        for(Integer key: map.keySet()){
            int value=map.get(key);
            if(arr[value]==null){
                arr[value]=new ArrayList<>();
            }
            arr[value].add(key);
        }
        List<Integer> res=new ArrayList<>();
        for (int i = arr.length-1; i >=0 && k>0 ; i--) {
            if(arr[i]!=null){
                res.addAll(arr[i]);
                k-=arr[i].size();
            }
        }
        return res;
    }

    public List<Integer> topKFrequentMaxHeap(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //use maxheap decresing order
        PriorityQueue<Map.Entry<Integer,Integer>> maxheap=new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        for(Map.Entry entry:map.entrySet()){
            maxheap.add(entry);
        }
        List<Integer> res=new ArrayList<>();
        while (res.size()<k){
            res.add(maxheap.poll().getKey());
        }
        return res;
    }

    public List<Integer> topKFrequentTreeMap(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //use treemap
        TreeMap<Integer,List<Integer>> treeMap=new TreeMap<>();
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            if (!treeMap.containsKey(entry.getValue())){
                treeMap.put(entry.getValue(),new ArrayList<>());
            }
            treeMap.get(entry.getValue()).add(entry.getKey());
        }
        List<Integer> res=new ArrayList<>();
        while(res.size()<k){
            res.addAll(treeMap.pollLastEntry().getValue());
        }
        return res;
    }
}
