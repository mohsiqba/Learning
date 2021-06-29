package com.mohsin.learning.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : m0i005b (mohsin.iqbal@walmart.com)
 * Date : 24-May-2021
 * Description :
 */
public class BalancedString {
    public static void main(String[] args) {
        System.out.println(balancedString("WWEQERQWQWWRWWERQWEQ"));
    }
    public static int balancedString(String s) {
        int res=0;
        int share=s.length()/4;
        Map<Character,Integer> map=new HashMap();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
            if( map.get(ch)>share){
                res+=map.get(ch)-share;
                map.put(ch,share);
            }
        }
        return res;
    }
}
