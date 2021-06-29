package com.mohsin.learning.pointers2;

/**
 * @author : m0i005b (mohsin.iqbal@walmartlabs.com)
 * Date : 17-May-2021
 * Description :
 */
public class ComparingStringsContainingBackspaces {
    public static void main(String[] args) {
        System.out.println(comparingStringsContainingBackspaces("xy#z","xzz#"));
        System.out.println(comparingStringsContainingBackspaces("xy#z","xyz#"));
        System.out.println(comparingStringsContainingBackspaces("xp#","xyz##"));
        System.out.println(comparingStringsContainingBackspaces("xywrrmp","xywrrmu#p"));
    }

    static boolean comparingStringsContainingBackspaces(String str1, String str2){
        int right1=str1.length()-1,right2=str2.length()-1;
        while(right1 >=0 || right2 >=0){
            int validIdx1=findValidChar(str1,right1);
            int validIdx2=findValidChar(str2,right2);
            if(validIdx1==0 && validIdx2==0){
                return true;
            }
            if(validIdx1==0 || validIdx2==0){
                return false;
            }
            if(str1.charAt(validIdx1)!=str2.charAt(validIdx2)){
                return false;
            }
            right1=validIdx1-1;
            right2=validIdx2-1;
        }
        return true;
    }

    private static int findValidChar(String str, int idx) {
        int hash=0;
        while(idx>=0){
            if(str.charAt(idx)== '#'){
                hash++;
                idx--;
            } else if(hash>0){
                hash--;
                idx--;
            } else{
                break;
            }
        }
        return idx;
    }
}
