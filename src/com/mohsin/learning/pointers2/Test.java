package com.mohsin.learning.pointers2;

/**
 * @author : Mohsin Iqbal
 * Date : 13-Sep-2021
 * Description :
 */
public class Test {

    public static void main(String[] args) {
        encrypt("word");
        encrypt("reply");
    }

    public static String encrypt(String inputString) {
        char cipher[] = new char[]{'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c', 'd', 'e'};
        StringBuilder sb = new StringBuilder();
        for (char ch : inputString.toCharArray()) {
            sb.append(cipher[ch - 97]);
        }
        return sb.toString();
    }
}
