package com.mohsin.learning.Array;

/**
 * @author : Mohsin iqbal
 * Date : 02-Jul-2021
 * Description :
 */

/**
 * Longest Subsequence of Vowel in a given String containing all alphabets.
 * A subsequence is a sequence of letters in a string in order, but with any number of character removed.
 * For example, 3 letter subsequences of abcd are abc, abd, acd and bcd. Vowels are letters in the string aeiou.
 * Given a string, determine the length of the longest subsequence that contains all the vowels in order.
 * For example, the string aeeiiouu contains all the vowels in order. The string aeeiiaou does not because of the ‘a’ at position 5,
 * (0 based indexing). The first string is the longest subsequence of the second string that contains all vowels in order.
 */
public class LongestVowelSubsequence {

    public static void main(String[] args) {
        LongestVowelSubsequence.solve("aaejkioou"); //7
        LongestVowelSubsequence.solve("eeejkioou"); //0
        LongestVowelSubsequence.solve("aeiou"); //5
        LongestVowelSubsequence.solve("aeio"); //0
        LongestVowelSubsequence.solve("aeou"); //0
        LongestVowelSubsequence.solve("aiou"); //0
        LongestVowelSubsequence.solve("aeiaaioooaauuaeiu"); //10

    }
    static void solve(String str) {
        int strlen=str.length();
        char s[] = "aeiou".toCharArray();
        int a[][] = new int[5][strlen+1];
        for (int i = 0; i < s.length; i++) {
            for (int j = 1; j <= strlen; j++) {
                if (s[i] == str.charAt(j-1)) {
                    if (i == 0) {
                        a[i][j] = a[i][j-1] + 1;
                    } else {
                        a[i][j] = Math.max(a[i][j-1],a[i-1][j]) + 1;
                    }
                } else{
                    a[i][j]=a[i][j-1];
                }
            }
//            System.out.println(Arrays.toString(a[i]));
            if(a[i][strlen]==0) break;
        }
        System.out.println(a[4][strlen]);
    }

}
