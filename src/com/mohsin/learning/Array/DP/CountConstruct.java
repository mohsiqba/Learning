package com.mohsin.learning.Array.DP;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : m0i005b (mohsin.iqbal@walmartlabs.com)
 * Date : 13-May-2021
 * Description :
 */
public class CountConstruct {


    private static int countConstructDP(String target, String[] wordBank, Map<String,Integer> memo) {
        if(memo.containsKey(target)) return memo.get(target);
        if(target.isEmpty()) return 1;
        int count=0;
        for(String str:wordBank){
            if(target.startsWith(str)){
                count+=countConstructDP(target.substring(str.length()),wordBank,memo);
                memo.put(target,count);
            }
        }
        memo.put(target,count);
        return count;
    }

    private static int countConstruct(String target, String[] wordBank) {
        if(target.isEmpty()) return 1;
        int count=0;
        for(String str:wordBank){
            if(target.startsWith(str)){
                count+=countConstruct(target.substring(str.length()),wordBank);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countConstruct("abcdef", new String[]{"a", "bc", "def", "cdef", "abc"}));
        System.out.println(countConstruct("purple", new String[]{"p", "pur", "ple", "ur", "le"}));
        System.out.println(countConstruct("skateboard", new String[]{"s", "kat", "teboard", "board"}));
//        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeez", new String[]{"e", "ee", "eee", "eeee", "eeeee"}));
        System.out.println("----------------------");
        System.out.println(countConstructDP("abcdef", new String[]{"a", "bc", "def", "cdef", "abc"}, new HashMap<>()));
        System.out.println(countConstructDP("purple", new String[]{"p", "pur", "ple", "ur", "le"}, new HashMap<>()));
        System.out.println(countConstructDP("skateboard", new String[]{"s", "kat", "teboard", "board"}, new HashMap<>()));
        System.out.println(countConstructDP("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeez", new String[]{"e", "ee", "eee", "eeee", "eeeee"}, new HashMap<>()));

    }
}
