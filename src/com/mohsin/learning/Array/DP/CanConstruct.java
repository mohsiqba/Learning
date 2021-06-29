package com.mohsin.learning.Array.DP;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : m0i005b (mohsin.iqbal@walmartlabs.com)
 * Date : 13-May-2021
 * Description :
 */
public class CanConstruct {

    public static boolean canConstructDP(String target, String[] wordBank, Map<String, Boolean> memo) {
        if (memo.containsKey(target)) {
            return memo.get(target);
        }
        if (target.isEmpty()) return true;

        for (String str : wordBank) {
            if (target.startsWith(str)) {
                if (canConstructDP(target.substring(str.length()), wordBank, memo)) {
                    memo.put(target, true);
                    return true;
                }
            }
        }
        memo.put(target, false);
        return false;
    }

    public static boolean canConstruct(String target, String[] wordBank) {
        if (target.isEmpty()) return true;

        for (String str : wordBank) {
            if (target.startsWith(str)) {
                if (canConstruct(target.substring(str.length()), wordBank)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("abcdef", new String[]{"a", "bc", "def", "cdef", "abc"}));
        System.out.println(canConstruct("purple", new String[]{"p", "pur", "ple", "ur", "le"}));
        System.out.println(canConstruct("skateboard", new String[]{"s", "kat", "teboard", "board"}));
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeez", new String[]{"e", "ee", "eee", "eeee", "eeeee"}));
        System.out.println("----------------------");
        System.out.println(canConstructDP("abcdef", new String[]{"a", "bc", "def", "cdef", "abc"}, new HashMap<>()));
        System.out.println(canConstructDP("purple", new String[]{"p", "pur", "ple", "ur", "le"}, new HashMap<>()));
        System.out.println(canConstructDP("skateboard", new String[]{"s", "kat", "teboard", "board"}, new HashMap<>()));
        System.out.println(canConstructDP("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeez", new String[]{"e", "ee", "eee", "eeee", "eeeee"}, new HashMap<>()));

    }
}
