package com.mohsin.learning;

/**
 * @author : m0i005b (mohsin.iqbal@walmart.com)
 * Date : 26-Jun-2021
 * Description :
 */
class A implements Cloneable{
    String nameA;

    @Override
    protected Object clone()
            throws CloneNotSupportedException
    {
        return super.clone();
    }

    @Override
    public String toString() {
        return "A{" +
                "nameA='" + nameA + '\'' +
                '}';
    }
}
class B extends A{
    String nameB;

    @Override
    protected Object clone()
            throws CloneNotSupportedException
    {
        return super.clone();
    }

    @Override
    public String toString() {
        return "B{" +
                "nameA='" + nameA + '\'' +
                ", nameB='" + nameB + '\'' +
                '}';
    }
}

class C extends Object implements Cloneable{
    int id;
    long marks;
    double percent;
    boolean result;
    Integer id1;
    Long marks1;
    Double percent1;
    Boolean result1;
    A a;
    B b;

    protected A getA() throws CloneNotSupportedException {
        return (A) a.clone();
    }

    protected B getB() throws CloneNotSupportedException {
        return (B) b.clone();
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    @Override
    public String toString() {
        return "C{" +
                "id=" + id +
                ", marks=" + marks +
                ", percent=" + percent +
                ", result=" + result +
                ", id1=" + id1 +
                ", marks1=" + marks1 +
                ", percent1=" + percent1 +
                ", result1=" + result1 +
                ", a=" + a +
                ", b=" + b +
                '}';
    }
}
public class CloneExample {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println(Math.pow(2,30));
        System.out.println((Math.log10(9)/Math.log10(2))%1==0);
        C c=new C();
        c.id=1;
        c.id1=2;
        c.marks=2l;
        c.marks1=2L;
        c.percent=2.5d;
        c.percent1=2.5D;
        c.result=false;
        c.result1=Boolean.TRUE;
        c.a=new A();
        c.a.nameA="A";
        c.b=new B();
        c.b.nameB="B";
        c.b.nameA="BA";

        System.out.println("CloneExample.main");
        System.out.println("c orig = " + c);
        C clone=(C)c.clone();
        clone.a.nameA="AA";
        clone.b.nameB="BB";
        clone.b.nameA="BABA";
        clone.id1=9;
        clone.result1=true;
        clone.percent1=9.8;
        clone.marks1=98L;
        System.out.println("c clone= " + clone);
        System.out.println("c orig = " + c);
        System.out.println(c.getA());
    }

    static int getSum(int n){
        int sum=0;
        while(n!=0){
            sum+=sum+n%10;
            n=n/10;
        }
        return sum;
    }

}
