package com.mohsin.learning;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyClass {
    static String str = "a";

    public static void main(String[] args) {
//        new MyClass().method1();
        try{
            int i=10/1;
        }catch(Error e){
            System.out.println("Exception handled  properly in catch block");
        }
        System.out.println("Code after exception handling");

        System.out.println(str);
        Map<Integer,Integer> map=new LinkedHashMap<>();
        map.put(1,1);
        map.put(2,3);
        map.put(5,5);
        map.put(4,4);
        map.put(1,2);
        System.out.println(map);

//        String test="^" + "test$australia.,&".replaceAll("[-\/\\^$*+?.()|[\]{}]", "\\$&") + "$";
        Pattern p = Pattern.compile("[\\.\\*\\+\\?\\^\\${}\\(\\)|\\]\\[\\\\]");
        Matcher m = p.matcher("test$australia.,&+_`~^$$**-';:/");
        System.out.println(m.replaceAll("\\\\$0"));
        Matcher m1=p.matcher("BioMatrix International, LLC");
        System.out.println(m1.replaceAll("\\\\$0"));
        //BioMatrix International, LLC





    }

    void method1() {
        try {
            method2();
        } catch (Exception e) {
            str += "b";
        } finally {
            str += "f";
        }
    }

    void method2() throws Exception {
        try {
            method3();
            str += "c";
        } catch (Exception e) {
            str += "e";
            throw new Exception();
        } finally {
            str += "d";
        }
        method3();
        str += "e";
    }

    void method3() throws Exception {
        throw new Exception();
    }
}