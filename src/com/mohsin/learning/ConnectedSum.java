package com.mohsin.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ConnectedSum {

    public static void main(String[] args) {

        System.out.println(connectedSum(4, Arrays.asList("1 2","1 4")));
    }
    public static int connectedSum(int n, List<String> edges) {
        if(n < 2) {
            return n;
        }
        int result = 0;

        List<HashSet<Integer>> list = (new ArrayList<>());

        for(int i=0; i<n; i++) {
            HashSet<Integer> intHash = new HashSet<>();
            intHash.add(i+1);
            list.add(intHash);
        }

        for(String edge : edges) {
            String[] a = edge.split(" ");
            HashSet<Integer> value = null;
            for(int i=0; i<list.size(); ) {
                HashSet<Integer> item = list.get(i);
                if(item.contains(Integer.parseInt(a[0])) || item.contains(Integer.parseInt(a[1])) ) {
                    if(value == null) {
                        value = item;
                    }
                    else {
                        value.addAll(item);
                    }
                    list.remove(item);
                } else
                    i++;
            }
            list.add(value);
        }
        for(HashSet<Integer> item: list) {
            System.out.println(item);
            result += Math.ceil(Math.sqrt(item.size()));
        }
        return result;
    }
}
