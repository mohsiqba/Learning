package com.mohsin.learning.Array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : Mohsin Iqbal
 * Date : 27-May-2021
 * Description :
 */
public class letter_combinations_of_a_phone_number {

    public static void main(String[] args) {
        List<String> list=new LinkedList();
//        list.add("");
        System.out.println(list+"|"+list.size());
        letter_combinations_of_a_phone_number phoneNumber=new letter_combinations_of_a_phone_number();
//        System.out.println(phoneNumber.letterCombinations("234"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> list=new ArrayList();
        String[] map=new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        lc(digits.toCharArray(),list,0,new StringBuilder(),map);
        return list;
    }

    void lc(char[] digits,List<String> list,int start,StringBuilder sb,String[] map){
        if(start==digits.length){
            list.add(new String (sb));
            return;
        }
        int letter= digits[start]-'0';
        for(int i=0;i<map[letter].length();i++){
            sb.append(map[letter].charAt(i));
            lc(digits,list,start+1,sb,map);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
