package com.mohsin.learning;

public class MyClass {
    static String str = "a";

    public static void main(String[] args) {
//        new MyClass().method1();
        try{
            int i=10/0;
        }catch(Error e){
            System.out.println("Exception handled  properly in catch block");
        }
        System.out.println("Code after exception handling");

        System.out.println(str);
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