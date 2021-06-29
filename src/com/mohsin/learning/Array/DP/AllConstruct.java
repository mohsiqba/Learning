package com.mohsin.learning.Array.DP;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : m0i005b (mohsin.iqbal@walmartlabs.com)
 * Date : 13-May-2021
 * Description :
 */
public class AllConstruct {

    public static List<List<String>> allConstruct(String target, String[] wordBank) {
        if (target.isEmpty()) return new ArrayList<>();

        List<List<String>> resultList = new ArrayList<>();
        for (String str : wordBank) {
            if (target.startsWith(str)) {
                List<List<String>> list = allConstruct(target.substring(str.length()), wordBank);
                if (list.isEmpty()) {
                    List<String> newLL = new ArrayList() {{
                        add(str);
                    }};
                    resultList.add(newLL);
                } else {
                    for (List<String> ll : list) {
                        List<String> newLL = new ArrayList() {{
                            add(str);
                            addAll(ll);
                        }};
                        resultList.add(newLL);
                    }
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        System.out.println(allConstruct("abcdef", new String[]{"a", "bc", "def", "cdef", "abc"}));
        System.out.println(allConstruct("purple", new String[]{"p", "pur", "ple", "ur", "le"}));
        System.out.println(allConstruct("skateboard", new String[]{"s", "kat", "teboard", "board"}));
        System.out.println(allConstruct("xyz", new String[]{"x", "kat", "teboard", "board"}));
        System.out.println(allConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl"}));
//        System.out.println(allConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeez", new String[]{"e", "ee", "eee", "eeee", "eeeee"}));
        System.out.println("----------------------");
//        System.out.println(allConstructDP("abcdef", new String[]{"a", "bc", "def", "cdef", "abc"}, new HashMap<>()));
//        System.out.println(allConstructDP("purple", new String[]{"p", "pur", "ple", "ur", "le"}, new HashMap<>()));
//        System.out.println(allConstructDP("skateboard", new String[]{"s", "kat", "teboard", "board"}, new HashMap<>()));
//        System.out.println(allConstructDP("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeez", new String[]{"e", "ee", "eee", "eeee", "eeeee"}, new HashMap<>()));
    }
}
