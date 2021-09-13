package com.mohsin.learning.Array;

import java.util.Locale;

/**
 * @author : Mohsin Iqbal
 * Date : 27-May-2021
 * Description :
 */
public class PalindromicSubstring {

    public static void main(String[] args) {
        PalindromicSubstring palindromicSubstring=new PalindromicSubstring();
        System.out.println(palindromicSubstring.palindromicSubstring("abc"));
    }

    /**
     * count palindrome substrings
     * @param str
     * @return
     */
    int palindromicSubstring(String str){
        int count=0;
        for (int i = 0; i < str.length(); i++) {
            count+=helper(str,i,i);
            count+=helper(str,i,i+1);
        }
        return count;
    }
    int helper(String str, int left, int right){
        int count=0;
        while(left>=0 && right<str.length() && str.charAt(left)==str.charAt(right)){
            count++;
            left--;
            right++;
        }
        return count;
    }
}
